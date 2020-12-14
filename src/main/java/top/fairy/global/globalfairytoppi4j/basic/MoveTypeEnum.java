package top.fairy.global.globalfairytoppi4j.basic;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/12/5 14:56
 */
public enum MoveTypeEnum {
    forward("forword","前进"),
    back("back","后退"),
    left("left","左行"),
    right("right","右行"),
    automove("automove","自动运行"),
    stop("stop","停止");

    private MoveTypeEnum(String optKey,String optName){
        this.optKey = optKey;
        this.optName = optName;
    }

    //操作标示值
    private String optKey;
    //操作动作名称
    private String optName;

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public String getOptKey() {
        return optKey;
    }

    public void setOptKey(String optKey) {
        this.optKey = optKey;
    }
}
