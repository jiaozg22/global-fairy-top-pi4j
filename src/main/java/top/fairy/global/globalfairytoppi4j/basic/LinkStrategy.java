package top.fairy.global.globalfairytoppi4j.basic;

/**
 *
 * @description:连接策略。
 * @author: jiao_zg22
 * @time: 2020/12/7 23:30
 */
public interface LinkStrategy {
    //TODO: jiao_zg 通过端口的自动化测试，自动判断连接模式。
    void setModule(String module);
    boolean link();
}
