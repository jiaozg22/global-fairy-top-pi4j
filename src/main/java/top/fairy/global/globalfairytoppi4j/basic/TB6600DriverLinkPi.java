package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.RaspiPin;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 树莓派与TB6600电机的连接针脚
 * @date 2020/12/7 20:07
 */
public class TB6600DriverLinkPi implements LinkStrategy {
    public Pi pi = null;//树莓派
    public Chip chip = null;//电机

    private void TB6600DriverLinkPi(){}

    /**
     *
     * @description:生成一次连接的TB6600DriverLinkPi实例之后，后面对这次连接实例TB6600DriverLinkPi的操作，是针对相同的一组操作对象pi,chip的操作
     * @author: jiao_zg22
     * @time: 2020/12/8 0:02
     */
    private void TB6600DriverLinkPi(Pi pi3b,MotorDriver tb6600) throws Exception {
        if(pi3b == null || tb6600 == null){
            throw new Exception("连接的芯片不能为空");
        }
        pi = pi3b;
        chip = tb6600;
    }

    //输出
    //A+引脚初始值
    public RaspiPin OUT_A_PLUS = null;
    //A-引脚初始值
    public RaspiPin OUT_A_SUB = null;
    //B+引脚初始值
    public RaspiPin OUT_B_PLUS = null;
    //B-引脚初始值
    public RaspiPin OUT_B_SUB = null;

    //输入
    //使能+
    public RaspiPin IN_ENA_PLUS = null;
    //使能-
    public RaspiPin IN_ENA_SUB = null;

    //控制方向+
    public RaspiPin IN_DIR_PLUS = null;
    //控制方向-
    public RaspiPin IN_DIR_SUB = null;

    //脉冲控制速度+
    public RaspiPin IN_PUL_PLUS = null;
    //脉冲控制速度-
    public RaspiPin IN_PUL_SUB = null;


    @Override
    public void setModule(String module) {
        CathodeModule cathodeModule = new CathodeModule(null);
    }

    @Override
    public boolean link() {
        //判断策略
        return false;
    }
}
