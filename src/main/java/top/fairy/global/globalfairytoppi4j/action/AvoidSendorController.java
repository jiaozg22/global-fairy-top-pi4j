package top.fairy.global.globalfairytoppi4j.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fairy.global.globalfairytoppi4j.basic.sensor.AvoidSensor;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2021/1/24 23:46
 */
@RestController
@SpringBootApplication
@RequestMapping(value = "/sensor/avoid")
public class AvoidSendorController {
    private static final Logger logger = LogManager.getLogger();

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/observer" , method = RequestMethod.POST)
    String obser(@RequestParam(value = "radio") int radio) {
        logger.info("避障监测速率为：{}", radio);

        new Thread(){
            @Override
            public void run(){

                //监听针脚
                try {
                    AvoidSensor.observer();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        return "避障监控...";
    }

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/stop/observer" , method = RequestMethod.POST)
    String stopObserver() {
        logger.info("避障监听停止");

        new Thread(){
            @Override
            public void run(){

                //监听针脚
                try {
                    AvoidSensor.close();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        return "避障监控...";
    }
}
