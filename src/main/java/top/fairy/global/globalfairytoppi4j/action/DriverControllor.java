package top.fairy.global.globalfairytoppi4j.action;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fairy.global.globalfairytoppi4j.utils.GpioUtil;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/12/4 23:11
 */
@RestController
@SpringBootApplication
@RequestMapping(value = "/driver")
public class DriverControllor {
    private static final Logger logger = LogManager.getLogger();

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/startPi", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName") String userName) {
        logger.info("startPi");
        GpioController gpioController = GpioUtil.getGpioController();

        return "  " + gpioController;
    }

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/forword", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "speed") int speed) {
        logger.info("前进,速度为：{}",speed);
        GpioController gpioController = GpioUtil.getGpioController();

        return "  " + gpioController;
    }



    public static void main(String[] args) {
        try {
            GpioController gpio = GpioFactory.getInstance();
            // SoftPwm softPwm = SoftPwm.softPwmCreate(RaspiPin.GPIO_29.,100,100);
            //启动
            GpioPinDigitalOutput enableA = gpio.provisionDigitalOutputPin(
                    RaspiPin.GPIO_00, "wheelAOut1", PinState.HIGH);
            GpioPinDigitalOutput direct = gpio.provisionDigitalOutputPin(
                    RaspiPin.GPIO_01, "wheelAOut2", PinState.HIGH);

            Pin pulPinPwm = CommandArgumentParser.getPin(//A的使能控制
                    RaspiPin.class,    // pin provider class to obtain pin instance from
                    RaspiPin.GPIO_29,  // default pin if no pin argument found
                    args);
            System.out.println("开始");
            GpioPinPwmOutput pwm = gpio.provisionSoftPwmOutputPin(pulPinPwm);

            pwm.setPwmRange(100);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
