package top.fairy.global.globalfairytoppi4j.basic;

/**
 *
 * @description:策略
 * @author: jiao_zg22
 * @time: 2020/12/7 23:30
 */
public interface LinkStrategy {
    void setModule(String module);
    boolean link();
}
