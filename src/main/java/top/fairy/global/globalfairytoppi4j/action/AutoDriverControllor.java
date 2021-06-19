package top.fairy.global.globalfairytoppi4j.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fairy.global.globalfairytoppi4j.basic.Car;
import top.fairy.global.globalfairytoppi4j.basic.MoveTypeEnum;
import top.fairy.global.globalfairytoppi4j.beans.DataWorkBean;
import top.fairy.global.globalfairytoppi4j.service.IDataWorkService;

import javax.annotation.Resource;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 自动运行接口
 * 博客地址：https://blog.csdn.net/jiao_zg/category_10334151.html?spm=1001.2014.3001.5482
 * @date 2020/12/4 23:11
 */
@RestController
@RequestMapping(value = "/auto_driver")
public class AutoDriverControllor {
    private static final Logger logger = LogManager.getLogger();

    @Resource
    IDataWorkService iDataWorkService;


//    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
//    @RequestMapping(value = "/startPi", method = RequestMethod.GET)
//    String getUserByGet(@RequestParam(value = "userName") String userName) {
//        logger.info("startPi");
//        String result= "";
//        PinState MS42_AL_DIR_PLUS_VALUE = ControlCenter.MS42_AL_DIR_PLUS.getState();
//        if(MS42_AL_DIR_PLUS_VALUE == PinState.HIGH){
//            result = "启动树莓派成功";
//        }
//
//        return result;
//    }

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/opt" , method = RequestMethod.POST)
    String autoMove(@RequestParam(value = "defaultSpeed") int speed) {
        logger.info(MoveTypeEnum.automove.getOptName(),"速度为：{}",speed);

        new Thread(){
            @Override
           public void run(){
                Car.autoMove(speed);//小车运动
           }
        }.start();
        DataWorkBean dataWorkBean = new DataWorkBean();


        iDataWorkService.writeDate(dataWorkBean );
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
