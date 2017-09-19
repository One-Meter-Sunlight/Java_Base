package com.base.refrence;

/**
 * java 值和引用传递：
 * 基本数据类型都是值传递，传递的都是当前值的副本；
 * 引用数据类型都是引用传递，也就是传递的是内存地址。
 *
 * Created by ck on 2017-09-16.
 */
public class ValueRefrenceTransfer {

    // 内部类
    static class People {
        private int id;
        private String name;

        public People(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //  int
    private static void changeValue(int a) {
        a = 5;
    }

    //  String
    private static void changeValue(String b) {
        b = "aaa";
    }

    //  Object
    private static void changeValue(People people) {
        people.setName("张飞");
    }

    public static void main(String[] args) {
        /**
         * 值传递
         * 基本数据类型，在声明的时候系统就为它分配了内存
         */
        int a = 1;
        ValueRefrenceTransfer.changeValue(a);  // 这里传递的是值
        System.out.println(a);  // 不变

        String b = "A";
        ValueRefrenceTransfer.changeValue(b); // 这里传递的是值
        System.out.println(b); // 不变

        /**
         * 引用传递
         * 在声明的时候值分配了引用变量的内存空间
         * 非静态变量类型不能在静态上下文中引用
         */
        ValueRefrenceTransfer.People people = new ValueRefrenceTransfer.People(1, "黄忠");
        ValueRefrenceTransfer.changeValue(people);
        System.out.println(people.getName());
    }
}
