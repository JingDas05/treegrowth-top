package top.treegrowth.provider.serviceImpl.batch;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.treegrowth.provider.serviceImpl.batch.model.In;
import top.treegrowth.provider.serviceImpl.batch.model.Out;
import top.treegrowth.provider.serviceImpl.batch.step.ItemProcess;
import top.treegrowth.provider.serviceImpl.batch.step.ItemWriterCus;
import top.treegrowth.redis.dao.RedisDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 通过游标的方式从mybatis 数据库读取，之后经过process 处理放入到目标中
 *
 * @author wusi
 * @version 2017/3/18 8:38.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private ItemWriterCus itemWriter;
    @Autowired
    private JobListener jobListener;

    //这个可以添加Qualifier注解，生成多个job实例
    @Bean
    public Job calculateJob(JobBuilderFactory jobBuilderFactory, Step step) {
        return jobBuilderFactory.get("jobName")
                .incrementer(new RunIdIncrementer())
                .listener(jobListener)
                .start(step)
                .build();
    }

    //这个可以添加Qualifier注解，生成多个step实例
    @Bean
    public Step caseHostScoreStep(StepBuilderFactory stepBuilderFactory,
                                  ItemReader<In> reader,
                                  ItemProcess itemProcess) {
        return stepBuilderFactory.get("stepName")
                .<In, Out>chunk(500)
                .reader(reader)
                .processor(itemProcess)
                .writer(itemWriter)
                .build();
    }

    //SPEL表达式取jobParameters 的queryId 属性的值,注意这个地方返回的是接口ItemReader 的实现类
    //MyBatisCursorItemReader。否则找不到doRead方法，接口ItemReader没有doRead方法
    @Bean
    @StepScope
    public MyBatisCursorItemReader<In> reader(@Value("#{jobParameters['queryId']}") String queryId,
                                              @Value("#{jobParameters['setKey']}") String setKey) {
        MyBatisCursorItemReader<In> reader = new MyBatisCursorItemReader<>();
        /**
         *
         * queryId是mybatis top.treegrowth.mapper.Xml中的id
         *
         * <select id="getCaseExtIn" resultMap="caseExt">
         select C_ID, N_UPS, N_DOWNS, N_VIEWS, N_PX, N_MARK, N_FOLLOWS, N_GD_COUNT,N_COLLECT_COUNT,N_SHARES,N_COMMENTS
         from db_case.T_CASE_EXT
         where C_ID in
         <foreach item="item" index="index" collection="ids"
         open="(" separator="," close=")">
         #{item}
         </foreach>
         </select>
         */
        reader.setQueryId(queryId);
        //从redis 取数据集合
        Set ids = redisDao.getSet(setKey);
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        reader.setParameterValues(params);
        reader.setSqlSessionFactory(sqlSessionFactory);
        return reader;
    }

    @Bean
    @StepScope
    public ItemProcess process() {
        return new ItemProcess();
    }
}
