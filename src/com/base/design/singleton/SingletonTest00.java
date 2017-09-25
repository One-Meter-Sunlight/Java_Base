package com.base.design.singleton;

import com.base.jdk8.People;

/**
 * 单例模式的N中写法
 * 00：非延迟加载
 * <p>
 * Created by ck on 2017-09-18.
 */
public class SingletonTest00 {

    private static final SingletonTest00 singletonTest00 = new SingletonTest00();

    public static SingletonTest00 getInstance() {
        return singletonTest00;
    }

}
