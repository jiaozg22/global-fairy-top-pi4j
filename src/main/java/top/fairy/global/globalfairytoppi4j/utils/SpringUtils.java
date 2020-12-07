package top.fairy.global.globalfairytoppi4j.utils;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/12/5 15:38
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpringUtils implements ApplicationContextAware {
    private static final Logger logger = LogManager.getLogger();

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 初始化Spring上下文
     *
     * @param ctx 上下文对象
     */
    public static void initContext(ApplicationContext ctx) {
        if(ctx == null) {
            logger.warn("ApplicationContext is null.");
            return;
        }
        applicationContext = ctx;
    }


}
