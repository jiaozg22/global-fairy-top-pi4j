package top.fairy.global.globalfairytoppi4j.basic;


import com.pi4j.io.gpio.GpioPin;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 电机驱动器-TB6600;模拟器，主要用于监控及参数收集，如果需要与物理属性关联，只能假定驱动器及其连接正常，然后通过逻辑判断进行处理。但实际上无法获取驱动器本身针脚的数据
 *
 * @date 2020/12/4 23:17
 */
public class MotorDriver implements Chip{
    public String type = "TB6600";

    //电源
    public boolean power = true;

    //输入
    //使能+
    public GpioPin IN_ENA_PLUS = null;
    //使能-
    public GpioPin IN_ENA_SUB = null;

    //控制方向+
    public GpioPin IN_DIR_PLUS = null;
    //控制方向-
    public GpioPin IN_DIR_SUB = null;

    //脉冲控制速度+
    public GpioPin IN_PUL_PLUS = null;
    //脉冲控制速度-
    public GpioPin IN_PUL_SUB = null;

    //输出。如果需要获取驱动器针脚输出值，需要回接到树莓派针脚，然后监控树莓派针脚，进行读取数据获取。这里暂时不配置，也不连接。
    //TODO:JIAO_ZG22
    //A+引脚初始值
    public GpioPin OUT_A_PLUS = null;
    //A-引脚初始值
    public GpioPin OUT_A_SUB = null;
    //B+引脚初始值
    public GpioPin OUT_B_PLUS = null;
    //B-引脚初始值
    public GpioPin OUT_B_SUB = null;

    @Override
    public boolean link(MotorDriver this,Chip target ) {

        return false;
    }
}
