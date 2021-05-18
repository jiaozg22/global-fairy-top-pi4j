package top.fairy.global.globalfairytoppi4j.basic.sensor;

import top.fairy.global.globalfairytoppi4j.basic.sensor.dht11.SensorListener;

/**
 *
 * @description:传感器接口
 * @author: jiao_zg22
 * @time: 2021/5/18 16:48
 */
public interface Sensor {
    void addSensorListener(SensorListener sensorListener);
}
