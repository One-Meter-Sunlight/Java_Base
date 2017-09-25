package com.base.design.singleton;

import com.base.jdk8.People;

/**
 * 单例模式的N中写法
 * 02：延迟加载，静态属性懒汉模式 + 同步锁，请求的时候进行初始化，效率低
 * <p>
 * Created by ck on 2017-09-18.
 */
public class SingletonTest02 {

    private static SingletonTest02 singletonTest02;

    public static synchronized SingletonTest02 getInstance() {
        if (null == singletonTest02) {
            return new SingletonTest02();
        }
        return singletonTest02;
    }

}
