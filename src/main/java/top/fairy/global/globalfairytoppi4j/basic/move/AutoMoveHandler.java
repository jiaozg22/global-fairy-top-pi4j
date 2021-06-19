package top.fairy.global.globalfairytoppi4j.basic.move;

import top.fairy.global.globalfairytoppi4j.basic.MoveTypeEnum;

import java.util.EventListener;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 自动运行处理器
 * @date 2020/12/13 20:57
 */
public class AutoMoveHandler {
    public boolean obstacle = true;
    public static boolean isNeedStop = false;
    public static String moveType = MoveTypeEnum.forward.getOptKey();//自动运动类型
    public static String currentOpt = MoveTypeEnum.forward.getOptKey();//当前需要启用的操作

    //自动运行过程中需要监听各类突发事件，设置时间监听器
    public static EventListener eventListener = new EventListener() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    };

    //设置各类突发事件
    //TODO:JIAO_ZG22


    //多线程同步修改是否停止变量
    public synchronized boolean setIsNeddStop(boolean stopNeed){
        isNeedStop = stopNeed;
        //TODO:启用自动运行逻辑

        return true;
    }


}
