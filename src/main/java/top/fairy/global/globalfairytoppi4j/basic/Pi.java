package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.*;
import top.fairy.global.globalfairytoppi4j.utils.GpioUtil;

/**
 *
 * @description:
 * @author: jiao_zg22
 * @time: 2020/12/11 23:59
 * 需要连接设计图，请关注专栏：https://blog.csdn.net/jiao_zg/category_10334151.html
 *
 */  
public interface Pi {


    /**
     *
     * @description:在使用控制中心初始化时，就对针脚连接进行处理，不需要使用的时候进行连接
     * @author: jiao_zg22
     * @time: 2020/12/7 23:15
     */
     boolean link();

}
