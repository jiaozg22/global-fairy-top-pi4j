package top.fairy.global.globalfairytoppi4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlobalFairyTopPi4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalFairyTopPi4jApplication.class, args);
        //系统启动以后，默认往context里放置一个

//        SpringUtils.initContext(context);


    }

}
