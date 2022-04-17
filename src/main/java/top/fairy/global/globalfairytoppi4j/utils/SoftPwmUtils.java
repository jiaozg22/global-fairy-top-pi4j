package top.fairy.global.globalfairytoppi4j.utils;

import com.pi4j.wiringpi.SoftPwm;


/**
 * @author jiao_zg22
 * @version 1.0
 * @description 软pwm详解
 * @date 2021/3/23 16:09
 */
public class SoftPwmUtils {
    //设置gpio针脚29号为软pwm针脚。

    /**
     * 本质上是模拟一个脉冲：1.设定一个脉冲的相对宽度（100，方便后面设置占空比的时候，更加直观）
     * 2.设定占空比
     * 3.设定一个脉冲的持续时间（100相对宽度，对应的实际时间，单位为毫秒）
     * 1.SoftPwm.softPwmCreate(29, 0, 100);
     * 2.SoftPwm.softPwmWrite(29, i);
     * 3.Thread.Sleep(100);
     * SoftPwm.softPwmStop(29);
     */
    public void move() {
        long timestamp = 0l;
        SoftPwm.softPwmStop(29);
        SoftPwm.softPwmCreate(29, 0, 100);
        try {
            while (true) {
                // fade LED to fully ON
                long timestampBefore = timestamp;

                timestamp = System.currentTimeMillis();
                System.out.println(timestampBefore - timestamp);

                for (int i = 1; i <= 50; i++) {//稳定后的占空比为50.
                    SoftPwm.softPwmWrite(29, i);//为了速度上来就很高，设置一个缓冲启动
                    long timestampBefore2 = timestamp;
                    timestamp = System.currentTimeMillis();
                    System.out.println(timestampBefore2 - timestamp);
                    //50*100次 大约（有代码执行延迟）50000ms=5s后达到稳定。
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NoPublicClass noPublicClass = new NoPublicClass();
        System.out.println(noPublicClass.a);
    }


}
