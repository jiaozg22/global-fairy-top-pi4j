package top.fairy.global.globalfairytoppi4j.beans;


import javax.persistence.Entity;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2021/6/18 14:36
 */
@Entity
public class DataWorkBean {
    private String speed;
    private Integer ts;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }
}
