package top.fairy.global.globalfairytoppi4j.basic.sensor.dht11;


/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2021/5/18 18:27
 */
public class TemperatureListener implements SensorListener {
    public static float highLevel = 30.00f;

    @Override
    public void actionPerformed(SensorEvent sensorEvent) {
        if(highLevel > sensorEvent.getValue()){
            sensorEvent.action();
        }
    }
}
