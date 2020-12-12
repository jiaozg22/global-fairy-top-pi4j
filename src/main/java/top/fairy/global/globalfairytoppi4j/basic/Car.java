package top.fairy.global.globalfairytoppi4j.basic;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/12/4 23:16
 */
public class Car {
    //本小车的组成：两个TB6600作为驱动器，控制四个42步进电机
    //左向驱动器
    public MotorDriver motorLeft = new MotorDriver();
    //右向驱动器
    public MotorDriver motorRight = new MotorDriver();

    public ControlCenter pi = new ControlCenter();

}
