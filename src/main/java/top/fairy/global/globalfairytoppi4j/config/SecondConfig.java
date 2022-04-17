//package top.fairy.global.globalfairytoppi4j.config;
//
///**
// *
// * @description:
// * 参考项目：https://gitee.com/8210/springboot-tdengine.git
// * https://blog.csdn.net/qq_36608921/article/details/108119386
// */
//
//import org.apache.ibatis.session.SqlSessionFactory;
////import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
//@Configuration
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "twoSqlSessionFactory",
//        transactionManagerRef = "twoTransactionManager",
//        basePackages = {"top.fairy.global.globalfairytoppi4j.mapper.tdengine"})
//@MapperScan(basePackages = "top.fairy.global.globalfairytoppi4j.mapper.tdengine", sqlSessionTemplateRef  = "twoSqlSessionTemplate")
//public class SecondConfig {
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    @Autowired
//    private HibernateProperties hibernateProperties;
//
//    @Bean(name = "mysqlDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.mysql")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "twoSqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("twoDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/tdengine/*.xml"));
//        return bean.getObject();
//    }
//    @Bean(name = "twoTransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("twoDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean(name = "twoSqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    private Map getVendorProperties(DataSource dataSource) {
//        return jpaProperties.getProperties();
//    }
////    @Bean(name = "entityManagerFactorySecond")
////    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond(EntityManagerFactoryBuilder builder) {
////        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
////                jpaProperties.getProperties(), new HibernateSettings());
////
////        return builder
////                .dataSource(mysqlDataSource)
////                .properties(properties)
////                .packages("com.**.entity") //设置实体类所在位置
////                .persistenceUnit("secondPersistenceUnit")
////                .build();
////    }
//
//
//}
