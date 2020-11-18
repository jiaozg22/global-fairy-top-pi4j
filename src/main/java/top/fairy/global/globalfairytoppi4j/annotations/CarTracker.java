package top.fairy.global.globalfairytoppi4j.annotations;

import java.lang.reflect.Method;

/**
 * @author jiao_zg
 */
public class CarTracker {

    public static void trackObserving(int[] ints,Class<?> clz){
        for(Method m : clz.getDeclaredMethods()){
            Observing observing = m.getAnnotation(Observing.class);
            if(observing != null){
                System.out.println(m.getName() + "小车运行速度限制："+observing.observerMaxSpeed());
                System.out.println(m.getName() + "小车运行方向："+observing.direct());
            }

        }
    }
}
