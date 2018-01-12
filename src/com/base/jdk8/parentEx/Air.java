package com.base.jdk8.parentEx;

/**
 * 父子调用 : 父类的引用指向子类的对象，首先调用父类的构造方法，如果父类和子类中都有同一个成员变量，会引用父类的，
 *           子类重写父类的方法，父类的引用调用的时候会调用子类的方法
 * 我是父亲构造方法
 * 我是儿子构造方法
 * 19
 * 儿子打印
 * @author ck
 * @date 2017/12/26 14:32
 */
public class Air {

    int age = 19;

    public Air() {
        System.out.println("我是父亲构造方法");
    }

    public void print() {
        System.out.println("父亲打印");
    }

}

class SubAir extends Air {

    int age = 46;

    public SubAir() {
        System.out.println("我是儿子构造方法");
    }

    @Override
    public void print() {
        System.out.println("儿子打印");
    }

    public static void main(String[] args) {
        Air air = new SubAir();
        System.out.println(air.age);
        air.print();
    }
}
