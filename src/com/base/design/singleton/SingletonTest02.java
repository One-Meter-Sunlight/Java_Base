package com.base.design.singleton;

import com.base.jdk8.People;

/**
 * 单例模式的N中写法
 * 02：静态属性懒汉模式 + 同步锁，请求的时候进行初始化
 * <p>
 * Created by ck on 2017-09-18.
 */
public class SingletonTest02 {

    private static People people;

    public static synchronized People GetPeople() {
        if (null == people) {
            return new People();
        }
        return people;
    }

}
