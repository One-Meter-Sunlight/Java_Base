package com.base.design.singleton;

import com.base.jdk8.People;

/**
 * 单例模式的N中写法
 * 01：延迟加载，静态属性，请求的时候进行初始化
 * <p>
 * Created by ck on 2017-09-18.
 */
public class SingletonTest01 {

    private static SingletonTest01 singletonTest01;

    public static SingletonTest01 getInstance() {
        if (null == singletonTest01) {
            return new SingletonTest01();
        }
        return singletonTest01;
    }

}
