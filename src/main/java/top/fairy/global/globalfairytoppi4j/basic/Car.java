package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.PinState;
import com.pi4j.wiringpi.SoftPwm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/12/4 23:16
 */
public class Car {
    private static final Logger logger = LogManager.getLogger();
    private static ControlCenter controlCenter = new ControlCenter();

    /**
     * @description:运动
     * @author: jiao_zg22
     * @time: 2020/12/13 17:08
     */
    public static void opt_type(int speed, String optKey) {

        com.pi4j.wiringpi.Gpio.wiringPiSetup();
        if (MoveTypeEnum.forward.getOptKey().equals(optKey)) {

            // create soft-pwm pins (min=0 ; max=100)
//            int setSpeedErrorNO = SoftPwm.softPwmCreate(29, 0, speed);

            Long timestamp = System.currentTimeMillis();
            controlCenter.MS42_AL_ENA_PLUS.setState(PinState.LOW);
            controlCenter.MS42_AL_DIR_PLUS.setState(PinState.LOW);

            controlCenter.MS42_AR_ENA_PLUS.setState(PinState.LOW);
            controlCenter.MS42_AR_DIR_PLUS.setState(PinState.HIGH);

            controlCenter.MS42_BL_ENA_PLUS.setState(PinState.LOW);
            controlCenter.MS42_BL_DIR_PLUS.setState(PinState.LOW);

            controlCenter.MS42_BR_ENA_PLUS.setState(PinState.LOW);
            controlCenter.MS42_BR_DIR_PLUS.setState(PinState.HIGH);


            SoftPwm.softPwmStop(PiLinkEnum.MS42_AL_PUL_PLUS.getPinNum());
            SoftPwm.softPwmCreate(PiLinkEnum.MS42_AL_PUL_PLUS.getPinNum(), 0, speed);

            SoftPwm.softPwmStop(PiLinkEnum.MS42_AR_PUL_PLUS.getPinNum());
            SoftPwm.softPwmCreate(PiLinkEnum.MS42_AR_PUL_PLUS.getPinNum(), 0, speed);

            SoftPwm.softPwmStop(PiLinkEnum.MS42_BL_PUL_PLUS.getPinNum());
            SoftPwm.softPwmCreate(PiLinkEnum.MS42_BL_PUL_PLUS.getPinNum(), 0, speed);

            SoftPwm.softPwmStop(PiLinkEnum.MS42_BR_PUL_PLUS.getPinNum());
            SoftPwm.softPwmCreate(PiLinkEnum.MS42_BR_PUL_PLUS.getPinNum(), 0, speed);

            // continuous loop
            while (true) {
                for (int i = 1; i <= speed; i++) {

                    SoftPwm.softPwmWrite(PiLinkEnum.MS42_AL_PUL_PLUS.getPinNum(), i);

                    SoftPwm.softPwmWrite(PiLinkEnum.MS42_AR_PUL_PLUS.getPinNum(), i);

                    SoftPwm.softPwmWrite(PiLinkEnum.MS42_BL_PUL_PLUS.getPinNum(), i);

                    SoftPwm.softPwmWrite(PiLinkEnum.MS42_BR_PUL_PLUS.getPinNum(), i);


                    try {
                        long timestampBefore2 = timestamp;
                        timestamp = System.currentTimeMillis();
                        System.out.println(timestampBefore2 - timestamp);
                        //50*100次 大约（有代码执行延迟）50000ms=5s后达到稳定。

                        Thread.sleep(1000);//设定1s,100个脉冲。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    timestamp = System.currentTimeMillis();
                    logger.info(timestamp);
                }


//            ControlCenter.MS42_AR_PUL_PLUS.setPwmRange(100);
//            ControlCenter.MS42_AR_PUL_PLUS.setPwm(speed);

            }


        } else if (MoveTypeEnum.left.getOptKey().equals(optKey)) {
            controlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
            controlCenter.MS42_AL_DIR_PLUS.setState(PinState.LOW);
//            ControlCenter.MS42_AL_PUL_PLUS.setPwmRange(speed);

            controlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);
            controlCenter.MS42_AR_DIR_PLUS.setState(PinState.LOW);
//            ControlCenter.MS42_AR_PUL_PLUS.setPwmRange(speed);
        } else if (MoveTypeEnum.right.getOptKey().equals(optKey)) {
            controlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
            controlCenter.MS42_AL_DIR_PLUS.setState(PinState.LOW);
//            ControlCenter.MS42_AL_PUL_PLUS.setPwmRange(speed);

            controlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);
            controlCenter.MS42_AR_DIR_PLUS.setState(PinState.HIGH);
//            ControlCenter.MS42_AR_PUL_PLUS.setPwmRange(speed);
        } else if (MoveTypeEnum.back.getOptKey().equals(optKey)) {
            controlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
            controlCenter.MS42_AL_DIR_PLUS.setState(PinState.LOW);
//            ControlCenter.MS42_AL_PUL_PLUS.setPwmRange(speed);

            controlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);
            controlCenter.MS42_AR_DIR_PLUS.setState(PinState.LOW);
//            ControlCenter.MS42_AR_PUL_PLUS.setPwmRange(speed);
        }

        logger.info("运动");
    }

    public static String stop() {

        logger.info("操作：stop");
        controlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
        controlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);

//        ControlCenter.MS42_AL_PUL_PLUS.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
//        ControlCenter.MS42_AR_PUL_PLUS.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

        controlCenter.gpio.shutdown();
//        controlCenter.gpio.unprovisionPin(controlCenter.MS42_AL_PUL_PLUS,controlCenter.MS42_AR_PUL_PLUS);
        return "运动停止成功";
    }

    public static String autoMove(int speed) {

        controlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
        controlCenter.MS42_AL_DIR_PLUS.setState(PinState.HIGH);
//        controlCenter.MS42_AL_PUL_PLUS.setPwmRange(speed);

        controlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);
        controlCenter.MS42_AR_DIR_PLUS.setState(PinState.HIGH);
//        controlCenter.MS42_AR_PUL_PLUS.setPwmRange(speed);


        //启动自动运行处理器，进行突发事件监听，并根据情况自动调用突发事件处理程序
        //TODO:JIAO_ZG22
        return "自动运行中";
    }
}
