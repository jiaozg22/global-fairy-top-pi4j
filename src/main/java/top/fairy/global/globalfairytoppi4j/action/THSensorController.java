package top.fairy.global.globalfairytoppi4j.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fairy.global.globalfairytoppi4j.basic.sensor.dht11.TemperatureAndHumiditySensor;
import top.fairy.global.globalfairytoppi4j.basic.sensor.dht22.DHT22Sensor;

import javax.annotation.Resource;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 温湿度传感器
 * 教程地址：https://blog.csdn.net/jiao_zg/category_10334151.html?spm=1001.2014.3001.5482
 * @date 2021/5/18 19:05
 */
@RestController
@RequestMapping(value = "/th_sensor")
public class THSensorController {
    private static final Logger logger = LogManager.getLogger();

    private static boolean stopMark = false;

    @Resource
    TemperatureAndHumiditySensor temperatureAndHumiditySensor;


    @Resource
    DHT22Sensor dht22Sensor;


    //读取温度湿度，并进行相应监听
    @RequestMapping(value = "/readth", method = RequestMethod.POST)
    String read(@RequestParam(value = "radio") int radio) {
        logger.info("读取速率为：{}", radio);

        new Thread() {
            @Override
            public void run() {

                while (!stopMark) {
                    try {
                        String value = temperatureAndHumiditySensor.read(null);
                        Thread.sleep(radio);//按照速录，暂停
                        logger.info(System.currentTimeMillis()  + "温度湿度读取结果为：" + value);
//                    //关闭树莓派
//                    TemperatureAndHumiditySensor.close();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }.start();


        return "读取温湿度...";
    }

    //关闭
    @RequestMapping(value = "/close", method = RequestMethod.POST)
    String read() {
        logger.info("关闭温湿度读取");

        new Thread() {
            @Override
            public void run() {

                //监听针脚
                try {
                    TemperatureAndHumiditySensor.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


        return "关闭读取温湿度...";
    }
}
