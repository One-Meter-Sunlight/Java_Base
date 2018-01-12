package com.base.design.singleton2;

/**
 * @author CK
 * @describe：单例模式：静态内部类
 * @date 2017/11/30 10:23
 */
public class Singleton_innerclass {

    // 私有构造方法
    private Singleton_innerclass(){}

    public Singleton_innerclass getInstance() {
        return innerclass.singleton;
    }

    // 静态内部类
    public static class innerclass {

        private static Singleton_innerclass singleton;

        static {
            singleton = new Singleton_innerclass();
        }

    }

}
