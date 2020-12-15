package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.impl.GpioPinImpl;
import com.pi4j.util.CommandArgumentParser;
import top.fairy.global.globalfairytoppi4j.utils.GpioUtil;
import com.pi4j.wiringpi.SoftPwm;
import com.pi4j.io.gpio.*;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 控制中心，pi4b,8g
 * @date 2020/12/5 16:22
 */
public class  ControlCenter implements Pi {

    //控制中心名字
    public static final String name = "树莓派";
    //控制中心型号
    public static final String version = "3b";
    //控制中心配置，3g内存
    public static final String config = "1g";

    String[] args = new String[0];
    //获取树莓派gpio控制模式引脚
    GpioController gpio = GpioFactory.getInstance();

    //树莓派的引脚设计规划：树莓派与小车轮子的连接：AL:左前方 ；AR:右前方 ;BL:左后方 ；BR:右后方
    //由于并没有使用四个驱动，使用了AL来控制左前方和由后方的轮子；使用AR来控制右前方和左后方的轮子的方式来使用
    public GpioPinDigitalOutput MS42_AL_ENA_PLUS = gpio.provisionDigitalOutputPin(
            RaspiPin.GPIO_00, "MS42_AL_ENA_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_AL_DIR_PLUS = gpio.provisionDigitalOutputPin(
            RaspiPin.GPIO_01, "MS42_AL_DIR_PLUS", PinState.LOW);


//    public Pin GPIP_29_PWM = CommandArgumentParser.getPin(//A的使能控制
//            RaspiPin.class,    // pin provider class to obtain pin instance from
//            RaspiPin.GPIO_29,  // default pin if no pin argument found
//            args);
//    public GpioPinPwmOutput MS42_AL_PUL_PLUS = gpio.provisionSoftPwmOutputPin(GPIP_29_PWM);

    //树莓派的引脚设计规划：树莓派与小车轮子的连接：AL:左前方 ；AR:右前方 ;BL:左后方 ；BR:右后方
    public GpioPinDigitalOutput MS42_AR_ENA_PLUS = gpio.provisionDigitalOutputPin(
            RaspiPin.GPIO_02, "MS42_AR_ENA_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_AR_DIR_PLUS = gpio.provisionDigitalOutputPin(
            RaspiPin.GPIO_04, "MS42_AR_DIR_PLUS", PinState.HIGH);

//    public Pin GPIP_28_PWM = CommandArgumentParser.getPin(//A的使能控制
//            RaspiPin.class,    // pin provider class to obtain pin instance from
//            RaspiPin.GPIO_28,  // default pin if no pin argument found
//            args);
//
//    public GpioPinPwmOutput MS42_AR_PUL_PLUS = gpio.provisionSoftPwmOutputPin(GPIP_28_PWM);


//    //用接口方法，提醒用户，不要忘记连接的过程
//    public static void linkToMotor(){
//        TB6600DriverLinkPi tB6600DriverLinkPi = new TB6600DriverLinkPi();
////        tB6600DriverLinkPi.link();
//    }

    @Override
    public  boolean link() {
//        linkToMotor();
        return true;
    }
}
