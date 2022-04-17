package top.fairy.global.globalfairytoppi4j.action;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.ConsoleColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fairy.global.globalfairytoppi4j.basic.Car;
import top.fairy.global.globalfairytoppi4j.basic.ControlCenter;
import top.fairy.global.globalfairytoppi4j.basic.MoveTypeEnum;
import top.fairy.global.globalfairytoppi4j.utils.GpioUtil;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * 教程地址：https://blog.csdn.net/jiao_zg/category_10334151.html?spm=1001.2014.3001.5482
 * @date 2020/12/4 23:11
 */
@RestController
@RequestMapping(value = "/driver")
public class DriverControllor {
    private static final Logger logger = LogManager.getLogger();

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/startPi", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName") String userName) {
        logger.info("startPi");
        //检查启动的各种状态
        String result= "";
//        ControlCenter.linkToMotor();


        return result;
    }

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/opt" , method = RequestMethod.POST)
    String moveType(@RequestParam(value = "speed") int speed,@RequestParam(value = "opt") String opt) {
        logger.info("{}，速度为：{}",MoveTypeEnum.forward.getOptName(),speed);

        new Thread(){
            @Override
           public void run(){
                Car.opt_type(speed,opt);//小车运动
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        return "运动...";
    }


    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/stop" , method = RequestMethod.GET)
    String stop(@RequestParam(value = "stop") String stop) {
        logger.info("操作：stop");
        Car.stop();


        return "运动...";
    }
}
