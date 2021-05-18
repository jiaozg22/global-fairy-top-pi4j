package top.fairy.global.globalfairytoppi4j.basic.sensor.dht11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2021/5/18 18:48
 */
public class HumidityEvent implements SensorEvent {
    private static final Logger logger = LogManager.getLogger();

    public static float highLevel = 30.00f;
    public float currentValue = 0.0f;

    public HumidityEvent(float currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public float getValue() {
        return currentValue;
    }

    @Override
    public void action() {
        if(highLevel > highLevel){
            logger.info("湿度告警，进行事件提醒");
        }
    }
}
