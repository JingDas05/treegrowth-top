package top.treegrowth.provider.serviceImpl.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.treegrowth.provider.serviceImpl.batch.model.In;
import top.treegrowth.provider.serviceImpl.batch.model.Out;
import top.treegrowth.provider.serviceImpl.batch.step.ItemProcess;
import top.treegrowth.provider.serviceImpl.batch.step.ItemReaderCustom;
import top.treegrowth.provider.serviceImpl.batch.step.ItemWriterCus;

/**
 * @author wusi
 * @version 2017/3/18 8:38.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job calculateJob() {
        return jobBuilderFactory.get("jobName")
                .incrementer(new RunIdIncrementer())
                .start(caseHostScoreStep())
                .build();
    }

    @Bean
    public JobParametersBuilder initJobParametersBuilder() {
        return new JobParametersBuilder();
    }

    private Step caseHostScoreStep() {
        return stepBuilderFactory.get("stepName")
                .<In, Out>chunk(50)
                .reader(new ItemReaderCustom().getReader("queryId", "redisKey", "mybatisParams"))
                .processor(process())
                .writer(writer())
                .build();
    }

    private ItemProcess process() {
        return new ItemProcess();
    }

    private ItemWriterCus writer() {
        return new ItemWriterCus();
    }
}
