package com.base.design.singleton2;

/**
 * @author CK
 * @describe：单例模式：懒汉模式-线程不安全
 * @date 2017/11/30 10:05
 */
public class Singleton_lazy {

    private static Singleton_lazy singleton = null;

    private Singleton_lazy() {
    }

    public static Singleton_lazy getInstance() {
        if (null == singleton) {
            return new Singleton_lazy();
        }
        return singleton;
    }
}
