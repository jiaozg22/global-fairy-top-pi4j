package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.PinState;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 共阴接地法
 * @date 2020/12/5 0:05
 */
public class CathodeModule {
    private static TB6600DriverLinkPi link = null;

    private MotorDriverDefConf motorDriverDefConf = null;

    private CathodeModule(){};//必须传参

    public CathodeModule(TB6600DriverLinkPi link){
        if(this.link != null){
            this.link = link;
        }else{
            this.link = new TB6600DriverLinkPi();
        }

        this.initalMotorDriver();
    }
    public boolean initalMotorDriver(){
        motorDriverDefConf.IN_DIR_SUB_DEFAULT = PinState.LOW;
        motorDriverDefConf.IN_ENA_SUB_DEFAULT = PinState.LOW;
        motorDriverDefConf.IN_PUL_SUB_DEFAULT = PinState.LOW;
        return true;
    }

}
