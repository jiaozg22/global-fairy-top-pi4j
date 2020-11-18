package top.fairy.global.globalfairytoppi4j.utils;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;

/**
 * 设置轮子的速度
 *
 */
public class PwmUtil {
//    public boolean setSpeed(Pin enableAWheel, int speed){
//        boolean result = true;
//        try{
//            GpioController gpio = GpioUtil.getGpioController();
//
//            GpioPinPwmOutput pwm = gpio.provisionSoftPwmOutputPin(enableAWheel);
//            pwm.setPwmRange(100);//默认值
//            pwm.setPwm(speed);
//        }catch (Exception e){
//            result = false;
//        }
//        return result;
//    }

    public static void main(String[] args){
        try{
            GpioController gpio = GpioFactory.getInstance();

            //启动
            GpioPinDigitalOutput wheelAOut1 = gpio.provisionDigitalOutputPin(
                    RaspiPin.GPIO_00, "wheelAOut1", PinState.HIGH);
            GpioPinDigitalOutput wheelAOut2 = gpio.provisionDigitalOutputPin(
                    RaspiPin.GPIO_01, "wheelAOut2", PinState.LOW);

            Pin enableAWheel = CommandArgumentParser.getPin(//A的使能控制
                    RaspiPin.class,    // pin provider class to obtain pin instance from
                    RaspiPin.GPIO_29,  // default pin if no pin argument found
                    args);

            GpioPinPwmOutput pwm = gpio.provisionSoftPwmOutputPin(enableAWheel);
            pwm.setPwmRange(3000);

            pwm.setPwm(2000);

            try {
                Thread.sleep(50000);//睡眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pwm.setPwmRange(1000);
            try {
                Thread.sleep(5000);//睡眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pwm.setPwmRange(0);
            try {
                Thread.sleep(5000);//睡眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pwm.setPwmRange(3000);
            try {
                Thread.sleep(5000);//睡眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pwm.setPwmRange(3000);
            try {
                Thread.sleep(2000000);//持续时间久一点
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
