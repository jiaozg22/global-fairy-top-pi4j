package top.fairy.global.globalfairytoppi4j.basic.sensor;

import com.pi4j.io.gpio.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.fairy.global.globalfairytoppi4j.basic.sensor.dht11.SensorListener;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 避障模块
 *
 * @date 2021/1/25 22:34
 */
public class AvoidSensor implements Sensor{
    private static final Logger logger = LogManager.getLogger();
    private static final String VCC = "1";//1号物理针脚，连接VCC针脚
    private static final String GND = "25";//25号物理针脚，连接GND针脚
    private static final Pin out = RaspiPin.GPIO_07;//7号物理针脚，对应GPIO_07,连接OUT针脚
    private static GpioController gpio = GpioFactory.getInstance();
    static GpioPinDigitalInput outReader = null;

    public static void observer(){
        //获取树莓派gpio控制模式引脚

        outReader = gpio.provisionDigitalInputPin(out);
        outReader.addListener(new AvoidSensorListener());
    }


    public static void close(){
        gpio.shutdown();
    }

    @Override
    public void addSensorListener(SensorListener sensorListener) {

    }
}
