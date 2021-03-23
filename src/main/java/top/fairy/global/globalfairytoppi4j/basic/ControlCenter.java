package top.fairy.global.globalfairytoppi4j.basic;

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
    public GpioPinDigitalOutput MS42_AL_ENA_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_AL_DIR_PLUS.getGpioNum(), "MS42_AL_ENA_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_AL_DIR_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_AL_DIR_PLUS.getGpioNum(), "MS42_AL_DIR_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_AL_PUL_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_AL_PUL_PLUS.getGpioNum(), "MS42_AL_PUL_PLUS", PinState.LOW);


    public GpioPinDigitalOutput MS42_AR_ENA_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_AR_DIR_PLUS.getGpioNum(), "MS42_AR_ENA_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_AR_DIR_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_AR_DIR_PLUS.getGpioNum(), "MS42_AR_DIR_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_AR_PUL_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_AR_PUL_PLUS.getGpioNum(), "MS42_AR_PUL_PLUS", PinState.LOW);

    public GpioPinDigitalOutput MS42_BL_ENA_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_BL_DIR_PLUS.getGpioNum(), "MS42_BL_ENA_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_BL_DIR_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_BL_DIR_PLUS.getGpioNum(), "MS42_BL_DIR_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_BL_PUL_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_BL_PUL_PLUS.getGpioNum(), "MS42_BL_PUL_PLUS", PinState.LOW);


    public GpioPinDigitalOutput MS42_BR_ENA_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_BR_DIR_PLUS.getGpioNum(), "MS42_BR_ENA_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_BR_DIR_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_BR_DIR_PLUS.getGpioNum(), "MS42_BR_DIR_PLUS", PinState.LOW);
    public GpioPinDigitalOutput MS42_BR_PUL_PLUS = gpio.provisionDigitalOutputPin(
            PiLinkEnum.MS42_BR_PUL_PLUS.getGpioNum(), "MS42_BR_PUL_PLUS", PinState.LOW);

//
//    //树莓派的引脚设计规划：树莓派与小车轮子的连接：AL:左前方 ；AR:右前方 ;BL:左后方 ；BR:右后方
//    public GpioPinDigitalOutput MS42_AR_ENA_PLUS = gpio.provisionDigitalOutputPin(
//            RaspiPin.GPIO_02, "MS42_AR_ENA_PLUS", PinState.LOW);
//    public GpioPinDigitalOutput MS42_AR_DIR_PLUS = gpio.provisionDigitalOutputPin(
//            RaspiPin.GPIO_04, "MS42_AR_DIR_PLUS", PinState.HIGH);


    //    public Pin GPIP_29_PWM = CommandArgumentParser.getPin(//A的使能控制
//            RaspiPin.class,    // pin provider class to obtain pin instance from
//            RaspiPin.GPIO_29,  // default pin if no pin argument found
//            args);
//    public GpioPinPwmOutput MS42_AL_PUL_PLUS = gpio.provisionSoftPwmOutputPin(GPIP_29_PWM);

    @Override
    public  boolean link() {
//        linkToMotor();
        return true;
    }
}
