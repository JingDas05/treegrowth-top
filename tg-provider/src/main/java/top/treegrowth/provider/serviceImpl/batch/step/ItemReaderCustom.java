package top.treegrowth.provider.serviceImpl.batch.step;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 这个地方用了mybatis的reader，还有别的reader,他们都是实现了ItemReader接口
 *
 * @author wusi
 * @version 2017/3/18 16:10
 */
public class ItemReaderCustom {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public<T> ItemReader<T> getReader(String queryId, String redisSetKey, String paramName) {
        MyBatisCursorItemReader<T> reader = new MyBatisCursorItemReader<>();
        /**
         *
         * queryId是mybatis mapper.Xml中的id
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
        //Set ids = iRedisService.getValueFromSet(redisSetKey);
        Map<String, Object> params = new HashMap<>();
        //params.put(paramName, ids);
        reader.setParameterValues(params);
        reader.setSqlSessionFactory(sqlSessionFactory);
        return reader;
    }
}
