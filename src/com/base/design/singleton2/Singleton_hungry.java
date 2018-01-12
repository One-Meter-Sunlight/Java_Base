package com.base.design.singleton2;

/**
 * @author CK
 * @describe：单例模式：饿汉模式-线程安全
 * @date 2017/11/30 10:02
 */
public class Singleton_hungry {

    private static Singleton_hungry singleton = new Singleton_hungry();

    /**
     * 这里必须要设置空的构造方法为private的，否则，调用者可以通过构造方法获得对象
     */
    private Singleton_hungry() {
    }

    public static Singleton_hungry getInstance() {
        return singleton;
    }
}
