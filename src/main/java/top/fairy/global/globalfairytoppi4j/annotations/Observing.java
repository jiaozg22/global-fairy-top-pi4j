package top.fairy.global.globalfairytoppi4j.annotations;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Observing {

    //观测小车的速度限制
    public int observerMaxSpeed() default -1;

    //观测小车的运行方向String 数字1：前进 2：后退 3：左侧前进 4：右侧前进 5：顺时旋转 6：逆时旋转
    public String direct();
}
