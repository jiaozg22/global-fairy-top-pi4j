package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.PinState;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 共阴接地法
 * @date 2020/12/5 0:05
 */
public class CathodeModule {
    private MotorDriver motorDriver = null;
    private CathodeModule(){};//必须传参
    public CathodeModule(MotorDriver md){
        if(md != null){
            motorDriver = md;
        }else{
            motorDriver = new MotorDriver();
        }

    }
    public boolean initalMotorDriver(){
        motorDriver.IN_DIR_SUB_DEFAULT = PinState.LOW;
        motorDriver.IN_ENA_SUB_DEFAULT = PinState.LOW;
        motorDriver.IN_PUL_SUB_DEFAULT = PinState.LOW;

        return true;
    }

}
