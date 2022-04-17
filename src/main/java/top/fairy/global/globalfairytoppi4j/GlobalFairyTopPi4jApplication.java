package top.fairy.global.globalfairytoppi4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
//        (exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages ={"top.fairy.global.globalfairytoppi4j" })
@MapperScan("top.fairy.global.globalfairytoppi4j.mapper")
public class GlobalFairyTopPi4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalFairyTopPi4jApplication.class, args);
        //系统启动以后，默认往context里放置一个

//        SpringUtils.initContext(context);


    }

}
