package com.base.design.singleton2;

/**
 * @author CK
 * @describe：
 * @date 2017/11/30 10:47
 */
public class Singleton_syn_validate_volatile {

    // volatile防止指令重排
    private static volatile Singleton_syn_validate_volatile singleton = null;

    private Singleton_syn_validate_volatile() {
    }

    /**
     * 同步代码块+多重校验+volatile
     * 解决了JVM指令重排的问题，但是依然可以通过反射获得多个实例
     *
     * @return
     */
    public static Singleton_syn_validate_volatile getInstance() {
        if (null == singleton) {  // 1
            synchronized (Singleton_syn_validate_volatile.class) {  // 2
                if (null == singleton) {  // 3
                    return new Singleton_syn_validate_volatile();
                }
            }
        }
        return singleton;
    }
}
