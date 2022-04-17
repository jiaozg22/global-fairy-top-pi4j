package top.fairy.global.globalfairytoppi4j.basic.sensor.dht22;

import com.pi4j.io.gpio.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import top.fairy.global.globalfairytoppi4j.basic.sensor.*;

import java.util.Arrays;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 温湿度传感器
 * @date 2021/5/18 16:48
 */
@Component
public class DHT22Sensor implements Sensor {
    private static final Logger logger = LogManager.getLogger();

    private static final String VCC = "1";//1号物理针脚，连接VCC针脚；跟避障传感器复用同一个针脚
    private static final String GND = "9";//9号物理针脚，连接GND针脚
    private static final Pin dataPin = RaspiPin.GPIO_04;//12号物理针脚，对应GPIO_01,连接DATA针脚
    public static final int HIGH_TIME = 32;
    private static GpioController gpio = null;
    private static GpioPinDigitalOutput dataPinData = null;

    static GpioPinDigitalInput outReader = null;

    public static int readData;
    public static long databuf;
    public static int crc;

    public THListener thListener ;


    //读取针脚数据。data针脚：既是控制线，又是数据线；先发送控制信号，然后等待100ms,开始接收数据；
    //数据格式：8位湿度传感器湿度数+8位温度传感器小数，8位温度传感器整数+8位温度传感器小数，+8位校验数据。

    public String read(int[] oneData) {
        if (gpio == null) {//第一次初始化，后面无需初始化
            gpio = GpioFactory.getInstance();
            logger.info("初始化gpio实例");
        }

        try {
            Thread.sleep(1000);//时延1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (dataPinData == null) {//第一次初始化数据针脚，后面无需初始化
            dataPinData = gpio.provisionDigitalOutputPin(
                    dataPin, "data", PinState.HIGH);

            logger.info("初始化{}实例,电平为：{}", dataPin,dataPinData.getState().getValue());
        }
        logger.info("数据针脚电阻拉高,状态为：{}",dataPinData.getState().getValue());


        //湿度
        int[] humidity_bit = new int[8];//湿度整数位
        int[] humidity_point_bit = new int[8];//湿度小数位

        //温度
        int[] temperature_bit = new int[8];//温度整数位
        int[] temperature_point_bit = new int[8];//温度小数位

        //校验位
        int[] check_bit = new int[8];//校验位
        int check = 0;//校验结果

        if (oneData == null) {
            oneData = new int[40];
        }

        dataPinData.setPullResistance(PinPullResistance.PULL_UP);


        try {
            Thread.sleep(1000);//时延1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(18);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dataPinData.setMode(PinMode.DIGITAL_INPUT);

        int i = 0;
        boolean mark = false;

        while (i <= 40) {//读取数据位
            dataPinData.pulse(53);
            long lowTimeUsStart = System.nanoTime();
            long lowTimeUsEnd = System.nanoTime();
            dataPinData.pulse(8);

            //记录时间戳低电平和高电平之间的时间差，来判断是0还是1
            long highTimeUsStart = System.nanoTime();
            long highTimeUsEnd = System.nanoTime();

            while (dataPinData.getState().getValue() == 1) {
                if(mark){
                    logger.info("高电平{}", System.nanoTime());
                    mark = false;
                }
            }

            mark = true;
            highTimeUsEnd = System.nanoTime();

            logger.info("{}：高电平", i, highTimeUsEnd - highTimeUsStart);
            System.out.println("毫秒数差距" + (highTimeUsEnd - highTimeUsStart));

//            logger.info("{}：高电平的时间={}", i, highTimeEnd - lowTimeStart);
            if ((highTimeUsEnd - highTimeUsStart) < 27) {
                System.out.println(i + "读取数值0");
//                oneData[i] = 0;
            } else {
                System.out.println(i + "读取数值0");

//                oneData[i - 1] = 1;
            }
            //“0”的格式为：54微秒的低电平和23-27微秒的高电平，
            //“1”的格式为：54微秒的低电平加68-74微秒的高电平

//            logger.info("第" + i + "位数字，值为：" + oneData[i]);

            if (i < 8) {
                humidity_bit[i] = oneData[i];
            }
            if (i >= 8 && i < 16) {
                humidity_point_bit[i - 8] = oneData[i];
            }

            if (i >= 16 && i < 24) {
                temperature_bit[i - 16] = oneData[i];
            }
            if (i >= 24 && i < 32) {
                temperature_point_bit[i - 24] = oneData[i];
            }
            if (i >= 32 && i < 40) {
                check_bit[i - 32] = oneData[i];
            }
            i++;
//            }

//            }
        }


        String humidity_str = Arrays.toString(humidity_bit).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        String humidity_point_str = Arrays.toString(humidity_bit).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        String temperature_str = Arrays.toString(humidity_bit).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        String temperature_point_str = Arrays.toString(humidity_bit).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        String check_str = Arrays.toString(check_bit).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");

        logger.info("humidity_str" + humidity_str);
        Integer humidity_bit_data = Integer.valueOf(humidity_str, 2);
        Integer humidity_point_bit_data = Integer.valueOf(humidity_point_str, 2);
        Integer temperature_bit_data = Integer.valueOf(temperature_str, 2);
        Integer temperature_point_bit_data = Integer.valueOf(temperature_point_str, 2);

        //校验
        Integer sum = humidity_bit_data + humidity_point_bit_data + temperature_bit_data + temperature_point_bit_data;
        StringBuffer result = new StringBuffer("");

        if (sum.equals(check_str)) {
            //结果转换
            result.append("h:").append(humidity_bit).append(humidity_point_bit).append(";")
                    .append("t:").append(temperature_bit).append(temperature_point_bit);

            //开启事件监听温度过高告警信息
            thListener.actionPerformed(new HumidityEvent(100.01f));
//            thListener.actionPerformed(new TemplateEvent(100.01f));

        } else {
            return "-1";//错误读取，需要重新调起
        }

        return result.toString();
    }


    public static void close() {
        if (gpio != null) {
            gpio.shutdown();
        }

    }

    //注册监听事件，温度湿度事件分别会将高于某个值的情况打印到日志中
    @Override
    public void addSensorListener(SensorListener sensorListener) {
        if (thListener == null) {
            this.thListener = (THListener) sensorListener;
        }
    }

}
