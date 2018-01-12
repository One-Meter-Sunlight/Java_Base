package com.base.design.singleton2;

/**
 * @author CK
 * @describe：单例模式：同步方法+多重校验
 * @date 2017/11/30 10:22
 */
public class Singleton_syn_validate {

    private static Singleton_syn_validate singleton = null;

    private Singleton_syn_validate() {
    }

    /**
     * 同步代码块+多重校验
     * <p>
     * 不足：看似没有问题，但是JVM在运行java字节码的时候会对指令进行优化，进行指令重排，
     * 如：a、初始化：给Singleton_syn_validate对象分配一个空间；
     *    b、实例化：将Singleton_syn_validate对象放入到这个分配的空间中；
     *    c、将栈中的对象的引用singleton指向这个对象。
     * 如果按照a－b－c这种顺序执行的话，当然没有问题，但是JVM进行指令重排之后可能会出现a——c——b这种执行顺序，所以当这里A线程访问到3时，
     * 对象为空，进行初始化和实例化，但是当进行到a——c时，B线程访问到3，这时它认为对象不为空则进行返回，但是实际上返回的却是不完整的对象
     *
     * @return
     */
    public static Singleton_syn_validate getInstance() {
        if (null == singleton) {    // 1
            synchronized (Singleton_syn_validate.class) {  // 2
                if (null == singleton) {  // 3
                    return new Singleton_syn_validate();
                }
            }
        }
        return singleton;
    }
}
