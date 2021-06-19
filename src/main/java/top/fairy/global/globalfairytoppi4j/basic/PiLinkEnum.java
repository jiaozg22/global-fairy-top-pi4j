package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 树莓派连接物理引脚，gpio针脚序号，42步进电机电机的映射关系
 * @date 2021/3/23 11:59
 */
public enum PiLinkEnum {

    //前左电机
    MS42_AL_ENA_PLUS(RaspiPin.GPIO_27,27),
    MS42_AL_DIR_PLUS(RaspiPin.GPIO_28,28),
    MS42_AL_PUL_PLUS(RaspiPin.GPIO_29,29),

    //前右电机
    MS42_AR_ENA_PLUS(RaspiPin.GPIO_24,24),
    MS42_AR_DIR_PLUS(RaspiPin.GPIO_25,25),
    MS42_AR_PUL_PLUS(RaspiPin.GPIO_26,26),

    //后左电机
    MS42_BL_ENA_PLUS(RaspiPin.GPIO_21,21),
    MS42_BL_DIR_PLUS(RaspiPin.GPIO_22,22),
    MS42_BL_PUL_PLUS(RaspiPin.GPIO_23,23),

    //后右电机
    MS42_BR_ENA_PLUS(RaspiPin.GPIO_00,00),
    MS42_BR_DIR_PLUS(RaspiPin.GPIO_02,02),
    MS42_BR_PUL_PLUS(RaspiPin.GPIO_03,03);

    /**
     * gpio引脚
     */
    private Pin gpioNum;

    /**
     * 物理连接引脚
     */
    private int pinNum;

    PiLinkEnum(Pin gpioNum, int pinNum) {
        this.gpioNum = gpioNum;
        this.pinNum = pinNum;
    }


    /**
     * 判断参数合法性
     */
    public static boolean isValidType(Pin gpioNum) {
        for (PiLinkEnum driverEnum : PiLinkEnum.values()) {
            if (driverEnum.gpioNum == gpioNum) {
                return true;
            }
        }
        return false;
    }

    public int getPinNum() {
        return pinNum;
    }

    public void setPinNum(int pinNum) {
        this.pinNum = pinNum;
    }

    public Pin getGpioNum() {
        return gpioNum;
    }

    public void setGpioNum(Pin gpioNum) {
        this.gpioNum = gpioNum;
    }
}
