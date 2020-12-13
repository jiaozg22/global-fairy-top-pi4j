package top.fairy.global.globalfairytoppi4j.basic;

import com.pi4j.io.gpio.PinState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/12/4 23:16
 */
public class Car {
    private static final Logger logger = LogManager.getLogger();

    //本小车的组成：两个TB6600作为驱动器，控制四个42步进电机
    //左向驱动器
    public static MotorDriver motorLeft = new MotorDriver();
    //右向驱动器
    public static MotorDriver motorRight = new MotorDriver();

    public static ControlCenter pi = new ControlCenter();

    /**
     *
     * @description:运动
     * @author: jiao_zg22
     * @time: 2020/12/13 17:08
     */
    public static void opt_type(int speed,String optKey){
        if(MoveTypeEnum.forward.getOptKey().equals(optKey)){
            ControlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AL_DIR_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AL_PUL_PLUS.setPwmRange(speed);

            ControlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AR_DIR_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AR_PUL_PLUS.setPwmRange(speed);
        }else if(MoveTypeEnum.left.getOptKey().equals(optKey)){
            ControlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AL_DIR_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AL_PUL_PLUS.setPwmRange(speed);

            ControlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AR_DIR_PLUS.setState(PinState.LOW);
            ControlCenter.MS42_AR_PUL_PLUS.setPwmRange(speed);
        }else if(MoveTypeEnum.right.getOptKey().equals(optKey)){
            ControlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AL_DIR_PLUS.setState(PinState.LOW);
            ControlCenter.MS42_AL_PUL_PLUS.setPwmRange(speed);

            ControlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AR_DIR_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AR_PUL_PLUS.setPwmRange(speed);
        }else if(MoveTypeEnum.back.getOptKey().equals(optKey)){
            ControlCenter.MS42_AL_ENA_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AL_DIR_PLUS.setState(PinState.LOW);
            ControlCenter.MS42_AL_PUL_PLUS.setPwmRange(speed);

            ControlCenter.MS42_AR_ENA_PLUS.setState(PinState.HIGH);
            ControlCenter.MS42_AR_DIR_PLUS.setState(PinState.LOW);
            ControlCenter.MS42_AR_PUL_PLUS.setPwmRange(speed);
        }
    }

    public static String stop() {
        logger.info("操作：stop");
        ControlCenter.MS42_AL_ENA_PLUS.setState(PinState.LOW);
        ControlCenter.MS42_AR_ENA_PLUS.setState(PinState.LOW);

        return "运动停止成功";
    }

}
