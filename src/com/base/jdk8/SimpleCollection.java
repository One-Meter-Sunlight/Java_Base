package com.base.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by ck on 2017-09-17.
 */
public class SimpleCollection {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int temp = (int) (Math.random() * 10 + i);
            intList.add(temp);
        }

        // 打印
        for (Integer i : intList) {
            System.out.println(i);
        }

        System.out.println("----------------jdk8 print 01----------------");
        intList.parallelStream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("----------------jdk8 print 02----------------");
        intList.parallelStream().forEach((final Integer i) -> System.out.println(i)); // 遍历的时候将集合元素绑定到i变量上

        System.out.println("----------------jdk8 print 03----------------");
        intList.parallelStream().forEach(integer -> System.out.println(integer));

        System.out.println("----------------jdk8 print 04----------------");
        intList.parallelStream().forEach(System.out :: println);
    }
}
