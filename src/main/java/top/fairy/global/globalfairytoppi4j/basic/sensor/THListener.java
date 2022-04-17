package top.fairy.global.globalfairytoppi4j.basic.sensor;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 监听器接口
 * @date 2021/5/18 20:42
 */
public class THListener implements SensorListener {

    @Override
    public void actionPerformed(SensorEvent sensorEvent) {
        sensorEvent.action();
    }

}
