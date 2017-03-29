package top.treegrowth.provider.dao.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 这个地方不能自己实力化，自己实例化会导致bindingException
 * 具体原理还没有看源码，mark一下
 *
 * @author wusi
 * @version 2017/3/30 07:30.
 */

//@Configuration
public class MybatisConfig {

//    @Bean
//    @Autowired
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
}
