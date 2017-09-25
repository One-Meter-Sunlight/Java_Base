package com.base.design.singleton;

import com.base.jdk8.People;

/**
 * 单例模式的N中写法
 * 03：延迟加载，静态内部类, 最安全的写法
 * 因为只有在调用内部类方法的时候才会去加载内部类，初始化，实例化，并且只加载一次，其他时候调用外部类是不会初始化内部类的，
 * 不占用空间，每个线程独一份，同时也线程安全；
 * <p>
 * Created by ck on 2017-09-18.
 */
public class SingletonTest03 {

    private static class SingletonTest03Handler {

        private static final SingletonTest03 singletonTest03 = new SingletonTest03();

        private static SingletonTest03 getInstance() {
            return SingletonTest03Handler.singletonTest03;
        }
    }

    public static void main(String[] args) {
        SingletonTest03Handler.getInstance();
    }

}
