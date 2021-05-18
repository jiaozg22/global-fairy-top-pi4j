package top.fairy.global.globalfairytoppi4j.basic.sensor.dht11;

import org.apache.tomcat.util.digester.SetPropertiesRule;

import java.util.Observable;
import java.util.Observer;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2021/5/18 18:29
 */
public class HumidityListener implements SensorListener {

    public static float highLevel = 30.00f;

    @Override
    public void actionPerformed(SensorEvent sensorEvent) {
        if(highLevel > sensorEvent.getValue()){
            sensorEvent.action();
        }
    }
}
