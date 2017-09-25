package com.base.design.singleton;

/**
 * 单例模式的N中写法
 * 04：延迟加载，双重检测锁定
 * 我们需要对 instance 进行第二次检查，目的是避开过多的同步（因为这里的同步只需在第一次创建实例时才同步，一旦创建成功，
 * 以后获取实例时就不需要同获取锁了），但在Java中行不通，因为同步块外面的if (null == instance)可能看到已存在，但不完整的实例。
 * <p>
 *     线程1访问getInstance，执行1-2-3，但是当执行到3的时候，线程1还没有调用构造函数进行实例化，只是进行了对象的初始化，但是该对象已然不为null，
 *     这时如果线程2访问外面的if (null == instance), instance不为null，则直接返回，所以该处可能有返回不完整对象的可能性；需改进。
 * Created by ck on 2017-09-18.
 */
public class SingletonTest04 {

    private static volatile SingletonTest04 instance = null;

    public static SingletonTest04 getInstance() {
        if (null == instance) {
            synchronized (SingletonTest04.class) { // 1
                if (null == instance) {  // 2
                    return new SingletonTest04(); // 3
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        SingletonTest04.getInstance();
    }

}
