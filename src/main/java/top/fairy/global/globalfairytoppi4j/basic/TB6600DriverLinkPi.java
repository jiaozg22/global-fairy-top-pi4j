package top.fairy.global.globalfairytoppi4j.basic;


/**
 * @author jiao_zg22
 * @version 1.0
 * @description 树莓派与TB6600电机的连接针脚
 * 详细电路连接，请参考resources目录下的static.doc文件夹
 * @date 2020/12/7 20:07
 */
public class TB6600DriverLinkPi implements LinkStrategy {

    public MotorDriver driver_AL_BR = new MotorDriver();//左前，右后控制驱动
    public MotorDriver driver_AR_BL = new MotorDriver();//右前，左后控制驱动

    public void TB6600DriverLinkPi(){}

    /**
     *
     * @description:生成一次连接的TB6600DriverLinkPi实例之后，后面对这次连接实例TB6600DriverLinkPi的操作，是针对相同的一组操作对象pi,chip的操作
     * @author: jiao_zg22
     * @time: 2020/12/8 0:02
     */
    public void TB6600DriverLinkPi(MotorDriver al_br,MotorDriver ar_bl) throws Exception {
        if(al_br == null || ar_bl == null){
            throw new Exception("连接的芯片不能为空");
        }

        driver_AL_BR = al_br;
        driver_AR_BL = ar_bl;
    }


    @Override
    public void setModule(String module) {
        CathodeModule cathodeModule = new CathodeModule(null);
    }

    @Override
    public boolean link() {
        ControlCenter controlCenter = new ControlCenter();
        driver_AL_BR.IN_ENA_PLUS = controlCenter.MS42_AL_ENA_PLUS;
        driver_AL_BR.IN_DIR_PLUS = controlCenter.MS42_AL_DIR_PLUS;
//        driver_AL_BR.IN_PUL_PLUS = controlCenter.MS42_AL_PUL_PLUS;

        driver_AR_BL.IN_ENA_PLUS = controlCenter.MS42_AR_ENA_PLUS;
        driver_AR_BL.IN_DIR_PLUS = controlCenter.MS42_AR_DIR_PLUS;
//        driver_AR_BL.IN_PUL_PLUS = controlCenter.MS42_AR_PUL_PLUS;

        //TODO:jiao_zg22 判断策略
        return false;
    }
}
