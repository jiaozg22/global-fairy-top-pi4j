package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 控制中心，pi4b,8g
 * @date 2020/12/5 16:22
 */
public final class  ControlCenter implements Pi {

    //控制中心名字
    public static final String name = "树莓派";
    //控制中心型号
    public static final String version = "3b";
    //控制中心配置，3g内存
    public static final String config = "1g";

    //树莓派的引脚设计规划：树莓派与小车轮子的连接：AL:左前方 ；AR:右前方 ;BL:左后方 ；BR:右后方
    //由于并没有使用四个驱动，使用了AL来控制左前方和由后方的轮子；使用AR来控制右前方和左后方的轮子的方式来使用
    public static final GpioPinDigitalOutput MS42_AL_ENA_PLUS = gpio.provisionDigitalOutputPin(
            RaspiPin.GPIO_00, "wheelAOut1", PinState.HIGH);
    public static final GpioPinDigitalOutput MS42_AL_DIR_PLUS = gpio.provisionDigitalOutputPin(
            RaspiPin.GPIO_01, "wheelAOut2", PinState.HIGH);

    private static final Pin GPIP_29_PWM = CommandArgumentParser.getPin(//A的使能控制
            RaspiPin.class,    // pin provider class to obtain pin instance from
            RaspiPin.GPIO_29,  // default pin if no pin argument found
            null);

    public static final GpioPinPwmOutput MS42_AL_PUL_PLUS = gpio.provisionSoftPwmOutputPin(GPIP_29_PWM);

    //树莓派的引脚设计规划：树莓派与小车轮子的连接：AL:左前方 ；AR:右前方 ;BL:左后方 ；BR:右后方
    public static final GpioPinDigitalOutput MS42_AR_ENA_PLUS = gpio.provisionDigitalOutputPin(
            RaspiPin.GPIO_02, "wheelAOut1", PinState.HIGH);
    public static final GpioPinDigitalOutput MS42_AR_DIR_PLUS = gpio.provisionDigitalOutputPin(
            RaspiPin.GPIO_04, "wheelAOut2", PinState.HIGH);

    private static final Pin GPIP_28_PWM = CommandArgumentParser.getPin(//A的使能控制
            RaspiPin.class,    // pin provider class to obtain pin instance from
            RaspiPin.GPIO_28,  // default pin if no pin argument found
            null);

    public static final GpioPinPwmOutput MS42_AR_PUL_PLUS = gpio.provisionSoftPwmOutputPin(GPIP_28_PWM);


    @Override
    public  boolean link() {
        TB6600DriverLinkPi tB6600DriverLinkPi = new TB6600DriverLinkPi();
        return true;
    }
}
