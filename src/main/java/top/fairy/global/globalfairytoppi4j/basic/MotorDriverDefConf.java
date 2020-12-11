package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.PinState;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 电机驱动器-TB6600
 * @date 2020/12/4 23:17
 */
public class MotorDriverDefConf {
    public String type = "TB6600";

    //电源
    public boolean power = true;

    //输出
    //A+引脚初始值
    public PinState OUT_A_PLUS_DEFAULT = PinState.HIGH;
    //A-引脚初始值
    public PinState OUT_A_SUB_DEFAULT = PinState.HIGH;
    //B+引脚初始值
    public PinState OUT_B_PLUS_DEFAULT = PinState.HIGH;
    //B-引脚初始值
    public PinState OUT_B_SUB_DEFAULT = PinState.HIGH;

    //输入
    //使能+
    public PinState IN_ENA_PLUS_DEFAULT = PinState.HIGH;
    //使能-
    public PinState IN_ENA_SUB_DEFAULT = PinState.LOW;

    //控制方向+
    public PinState IN_DIR_PLUS_DEFAULT = PinState.HIGH;
    //控制方向-
    public PinState IN_DIR_SUB_DEFAULT = PinState.LOW;

    //脉冲控制速度+
    public PinState IN_PUL_PLUS_DEFAULT = PinState.HIGH;
    //脉冲控制速度-
    public PinState IN_PUL_SUB_DEFAULT = PinState.LOW;


}
