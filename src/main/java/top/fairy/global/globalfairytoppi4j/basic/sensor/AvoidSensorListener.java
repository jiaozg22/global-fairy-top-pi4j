package top.fairy.global.globalfairytoppi4j.basic.sensor;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;


/**
 * @author jiao_zg22
 * @version 1.0
 * @description 避障监听器
 * @date 2021/1/25 22:36
 */
public class AvoidSensorListener implements GpioPinListenerDigital {
    private static final Logger logger = LogManager.getLogger();


    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        PinState state = event.getState();
        int value = state.getValue();
        if (value == 1) {
            logger.info("碰到了障碍，{}",new Date()); //
            try {
//                    device.startBind();
                //存库操作
                //发送邮箱操作
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
