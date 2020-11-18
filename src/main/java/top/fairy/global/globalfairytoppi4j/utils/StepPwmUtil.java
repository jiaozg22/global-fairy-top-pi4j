package top.fairy.global.globalfairytoppi4j.utils;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.wiringpi.SoftPwm;

/**
 * 步进电机驱动
 *
 */
public class StepPwmUtil {
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
//            SoftPwm softPwm = SoftPwm.softPwmCreate(RaspiPin.GPIO_29.,100,100);
            //启动
            GpioPinDigitalOutput enableA = gpio.provisionDigitalOutputPin(
                    RaspiPin.GPIO_00, "wheelAOut1", PinState.HIGH);
            GpioPinDigitalOutput direct = gpio.provisionDigitalOutputPin(
                    RaspiPin.GPIO_01, "wheelAOut2", PinState.HIGH);

            Pin pulPinPwm = CommandArgumentParser.getPin(//A的使能控制
                    RaspiPin.class,    // pin provider class to obtain pin instance from
                    RaspiPin.GPIO_29,  // default pin if no pin argument found
                    args);
            System.out.println("开始");
            GpioPinPwmOutput pwm = gpio.provisionSoftPwmOutputPin(pulPinPwm);

            pwm.setPwmRange(100);

            pwm.setPwm(100);
            System.out.println("设置完毕");
            try {
                Thread.sleep(5000);//睡眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pwm.setPwmRange(100);
            try {
                Thread.sleep(5000);//睡眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("停止");
            pwm.setPwmRange(0);
            try {
                Thread.sleep(5000);//睡眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正向运动");
            pwm.setPwmRange(100);
            try {
                Thread.sleep(5000);//睡眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("反方向运动");
            direct.setState(PinState.LOW);
            try {
                Thread.sleep(5000);//睡眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("使能停止");
            enableA.setState(PinState.LOW);
            try {
                Thread.sleep(5000);//睡眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("pwm减速一半");
            pwm.setPwm(50);
            try {
                Thread.sleep(5000);//睡眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pwm.setPwmRange(100);
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
