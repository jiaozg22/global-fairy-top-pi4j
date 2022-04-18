package top.fairy.global.globalfairytoppi4j.config;

/**
 *
 * @description:
 * 参考项目：https://gitee.com/8210/springboot-tdengine.git
 * https://blog.csdn.net/qq_36608921/article/details/108119386
 */

import org.apache.ibatis.session.SqlSessionFactory;
//import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "tdengineSqlSessionFactory",
        transactionManagerRef = "tdengineTransactionManager",
        basePackages = {"top.fairy.global.globalfairytoppi4j.mapper.tdengine"})
public class TdengineConfig {
//    @Autowired
//    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean(name = "tdengineDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.tdengine")
    public DataSource testTdengineDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tdengineSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("tdengineDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:top/fairy/global/globalfairytoppi4j/mapper/tdengine/*.xml"));
        return bean.getObject();
    }
    @Bean(name = "tdengineTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("tdengineDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "tdengineSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("tdengineSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
