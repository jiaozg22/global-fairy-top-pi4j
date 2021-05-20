package top.fairy.global.globalfairytoppi4j.basic.sensor.dht11;

import com.pi4j.io.gpio.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import top.fairy.global.globalfairytoppi4j.basic.PiLinkEnum;
import top.fairy.global.globalfairytoppi4j.basic.sensor.Sensor;

import java.util.Arrays;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 温湿度传感器
 * @date 2021/5/18 16:48
 */
@Component
public class TemperatureAndHumiditySensor implements Sensor {
    private static final Logger logger = LogManager.getLogger();

    private static final String VCC = "1";//1号物理针脚，连接VCC针脚；跟避障传感器复用同一个针脚
    private static final String GND = "9";//9号物理针脚，连接GND针脚
    private static final Pin dataPin = RaspiPin.GPIO_01;//12号物理针脚，对应GPIO_01,连接DATA针脚
    public static final int HIGH_TIME = 32;
    private static GpioController gpio = null;

    static GpioPinDigitalInput outReader = null;

    public static int readData;
    public static long databuf;
    public static int crc;

    public THListener thListener;


    //读取针脚数据。data针脚：既是控制线，又是数据线；先发送控制信号，然后等待100ms,开始接收数据；
    //数据格式：8位湿度传感器湿度数+8位温度传感器小数，8位温度传感器整数+8位温度传感器小数，+8位校验数据。

    public String read(int[] oneData) {
        if (gpio == null) {//第一次初始化，后面无需初始化
            gpio = GpioFactory.getInstance();
            logger.info("初始化gpio实例");
        }

        addSensorListener(thListener);


        StringBuffer result = new StringBuffer("");
        //每次读取是上一次的温湿度值，不是本次的值。
        int i = 0;
        if (oneData == null) {
            oneData = new int[40];
        }

        //湿度
        int[] humidity_bit = new int[8];//湿度整数位
        int[] humidity_point_bit = new int[8];//湿度小数位

        //温度
        int[] temperature_bit = new int[8];//温度整数位
        int[] temperature_point_bit = new int[8];//温度小数位

        //校验位
        int[] check_bit = new int[8];//校验位
        int check = 0;//校验结果
        //1.树莓派data引脚和dht11建立连接：
        //步骤一:
        //DHT11上电后（DHT11上电后要等待1S以越过不稳定状态在此期间不能发送任何指令），测
        //试环境温湿度数据，并记录数据，同时DHT11的DATA数据线由上拉电阻拉高一直保持高电平；
        //此时DHT11的DATA引脚处于输入状态，时刻检测外部信号。
        //步骤二:
        //微处理器的I/O设置为输出同时输出低电平，且低电平保持时间不能小于18ms（最大不得
        //超过30ms），然后微处理器的I/O设置为输入状态，由于上拉电阻，微处理器的I/O即DHT11的
        //DATA数据线也随之变高，等待DHT11作出回答信号。发送信号如图4所示：
        //图4 主机发送起始信号
        //步骤三:
        //DHT11的DATA引脚检测到外部信号有低电平时，等待外部信号低电平结束，延迟后DHT11的
        //DATA引脚处于输出状态，输出83微秒的低电平作为应答信号，紧接着输出87微秒的高电平通知
        //外设准备接收数据，微处理器的I/O此时处于输入状态，检测到I/O有低电平（DHT11回应信号）
        //后，等待87微秒的高电平后的数据接收，发送信号如图5所示：
        //图5 从机响应信号
        //步骤四:
        //由DHT11的DATA引脚输出40位数据，微处理器根据I/O电平的变化接收40位数据，位数据
        //“0”的格式为：54微秒的低电平和23-27微秒的高电平，位数据“1”的格式为：54微秒的低
        //电平加68-74微秒的高电平。位数据“0”、“1”格式信号如图6所示：
        //产品手册 DHT11
        //www.aosong.com 广州奥松电子有限公司 电话：400-630-5378 版本号:V1.3_20170331
        //图6
        //避免将元件长期放在结露和干燥的环境中以及以下环境。
        //-6-
        //结束信号：
        //DHT11的DATA引脚输出40位数据后，继续输出低电平54微秒后转为输入状态，由于上拉电
        //阻随之变为高电平。但DHT11内部重测环境温湿度数据，并记录数据，等待外部信号的到来。
        //表4 单总线信号特性
        //符号 参数 min type max 单位
        //Tbe 主机起始信号拉低时间 18 20 30 ms Tgo 主机释放总线时间 10 13 20 µS Trel 响应低电平时间 81 83 85 µS Treh 响应高电平时间 85 87 88 µS TLOW 信号“0”、“1”低电平时间 52 54 56 µS TH0 信号“0”高电平时间 23 24 27 µS TH1 信号“1”高电平时间 68 71 74 µS Ten 传感器释放总线时间 52 54 56 µS


        //1.1设置data针脚，引脚为输出并输出高电平，25ms,再接着输出一个低电平,持续27ms
        GpioPinDigitalOutput dataPinData = gpio.provisionDigitalOutputPin(
                dataPin, "data", PinState.HIGH);
        logger.info("设置data针脚为输出，并为高电平");
//        try {
//            Thread.sleep(25);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        dataPinData.pulse(25);//脉冲法将电平设置为高，持续时间25ms
        dataPinData.low();
//        try {
//            Thread.sleep(27);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        dataPinData.pulse(27);//脉冲法将电平设置为高，持续时间27ms
        //1.2 设置data针脚，引脚为输入，并设置为高电平，
//        GpioPinDigitalInput dataPinData = gpio.provisionDigitalInputPin(dataPin, "dataLow");
        dataPinData.setMode(PinMode.DIGITAL_INPUT);
        logger.info("设置data为为输入，值为：{}", dataPinData.getState().getValue());
        if (dataPinData.getState().getValue() == 0) {
            logger.info("等待高电平出现");
            //1.3等待信号的变化，高，低，高，之后才是数据
            while (dataPinData.getState().getValue() == 0) ;//等待高电平
            logger.info("设置输出状态，并设置为低电平，持续83ms,作为应答信号");
            dataPinData.setMode(PinMode.DIGITAL_OUTPUT);
            dataPinData.setState(PinState.LOW);
            dataPinData.pulse(83);//时钟方式持续83ms
//
//
//
            logger.info("紧接着输出87微秒的高电平通知");
            dataPinData.pulse(87);
            dataPinData.setState(PinState.HIGH);
            logger.info("外设准备接收数据，微处理器的I/O此时处于输入状态，检测到I/O有低电平（DHT11回应信号）");

            dataPinData.setMode(PinMode.DIGITAL_INPUT);
            while (dataPinData.getState().getValue() == 1) ;
            if (dataPinData.getState().getValue() == 0) {//检测到有低电平
                logger.info("后，等待87微秒的高电平后的数据接收，发送信号如图5所示：");

                dataPinData.pulse(87);
                while (i <= 40) {//读取数据位

                    //记录时间戳低电平和高电平之间的时间差，来判断是0还是1
                    long lowTimeStart = System.currentTimeMillis();
                    while (dataPinData.getState().getValue() == 0) ;
                    long lowTimeEnd = System.currentTimeMillis();
                    logger.info("{}：低电平的时间={}", i, lowTimeEnd - lowTimeStart);
                    long highTimeStart = System.currentTimeMillis();

                    while (dataPinData.getState().getValue() == 1) ;
                    long highTimeEnd = System.currentTimeMillis();
                    logger.info("{}：高电平的时间={}", i, highTimeEnd - highTimeStart);
                    if ((highTimeEnd - highTimeStart) < 27) {
                        oneData[i] = 0;
                    } else {
                        oneData[i] = 1;
                    }
                    //“0”的格式为：54微秒的低电平和23-27微秒的高电平，
                    //“1”的格式为：54微秒的低电平加68-74微秒的高电平

                    logger.info("第" + i + "位数字，值为：" + oneData[i]);

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
                }

            }
        }


        String humidity_str = Arrays.toString(humidity_bit);
        String humidity_point_str = Arrays.toString(humidity_bit);
        String temperature_str = Arrays.toString(humidity_bit);
        String temperature_point_str = Arrays.toString(humidity_bit);
        String check_str = Arrays.toString(check_bit);

        logger.info("humidity_str" + humidity_str);
        Integer humidity_bit_data = Integer.valueOf(humidity_str, 2);
        Integer humidity_point_bit_data = Integer.valueOf(humidity_point_str, 2);
        Integer temperature_bit_data = Integer.valueOf(temperature_str, 2);
        Integer temperature_point_bit_data = Integer.valueOf(temperature_point_str, 2);

        //校验
        Integer sum = humidity_bit_data + humidity_point_bit_data + temperature_bit_data + temperature_point_bit_data;

        if (sum.equals(check_str)) {
            //结果转换
            result.append("h:").append(humidity_bit).append(humidity_point_bit).append(";")
                    .append("t:").append(temperature_bit).append(temperature_point_bit);

            //开启事件监听温度过高告警信息
            thListener.actionPerformed(new HumidityEvent(100.01f));
            thListener.actionPerformed(new TemplateEvent(100.01f));

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
