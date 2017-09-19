package com.base.design.singleton;

import com.base.jdk8.People;

/**
 * 单例模式的N中写法
 * 03：静态 内部类, 最安全的写法
 * 因为只有在调用内部类方法的时候才会去加载内部类，其他时候调用外部类是不会初始化内部类的，不占用空间，
 * 同时也线程安全；
 * <p>
 * Created by ck on 2017-09-18.
 */
public class SingletonTest03 {

    private static class GeneratorPeople {

        private static final People people = new People();

        private static People GetPeople() {
            return people;
        }
    }

    public static void main(String[] args) {
        SingletonTest03.GeneratorPeople.GetPeople();
    }

}
