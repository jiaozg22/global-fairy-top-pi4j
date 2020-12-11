package top.fairy.global.globalfairytoppi4j.basic;


import com.pi4j.io.gpio.RaspiPin;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 电机驱动器-TB6600
 * @date 2020/12/4 23:17
 */
public class MotorDriver implements Chip{
    public String type = "TB6600";

    //电源
    public boolean power = true;



    @Override
    public boolean link(MotorDriver this,Chip target ) {

        return false;
    }
}
