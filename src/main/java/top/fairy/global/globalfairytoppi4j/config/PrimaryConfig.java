//package top.fairy.global.globalfairytoppi4j.config;
///**
// *
// * @description:
// * 参考项目：https://gitee.com/8210/springboot-tdengine.git
// * https://blog.csdn.net/qq_36608921/article/details/108119386
// */
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
////import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "oneSqlSessionFactory",
//        transactionManagerRef = "oneTransactionManager",
//        basePackages = {"top.fairy.global.globalfairytoppi4j.mapper.mysql"}) //设置Repository所在位置
////@MapperScan(basePackages = "top.fairy.global.globalfairytoppi4j.mapper.mysql", sqlSessionTemplateRef = "oneSqlSessionTemplate")
//public class PrimaryConfig {
//    /**
//     * 加载配置数据源
//     *
//     * @return
//     * @Primary 是指具有默认值
//     */
//    @Bean(name = "taosDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.taos")
//    @Primary
//    public DataSource taosDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "oneSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/mysql/*.xml"));
//        //Resource[] mapperLocations
//        return bean.getObject();
//    }
//
//    @Bean(name = "oneTransactionManager")
//    @Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("oneDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "oneSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}