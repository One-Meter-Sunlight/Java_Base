package com.base.design.singleton2;

/**
 * @author CK
 * @describe：单例模式：同步方法-线程安全，效率低
 * @date 2017/11/30 10:15
 */
public class Singleton_syn {

    private static Singleton_syn singleton = null;

    private Singleton_syn() {
    }

    /**
     * 增加synchronized 关键字
     * 效率低
     *
     * @return
     */
    public synchronized static Singleton_syn getInstance() {
        if (null == singleton) {
            return new Singleton_syn();
        }
        return singleton;
    }
}
