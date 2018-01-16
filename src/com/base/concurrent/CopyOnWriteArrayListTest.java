package com.base.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 结合迭代时删除有几种方式
 * 1、CopyOnWriteArrayList
 * 2、Iterator
 * Created by ck on 2018-01-07.
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {

        System.out.println("=====================方法一=====================");
        List<Integer> list = new CopyOnWriteArrayList(new Integer[]{1, 2, 3, 4, 5});
        list.forEach(System.out::println);
        for (int i = 0; i < list.size(); i++) {
            if (i == 3) {
                list.remove(3);
            }
        }
        System.out.println("after remove");
        list.forEach(System.out::println);

        System.out.println("=====================方法二=====================");
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.forEach(System.out::println);
        for (Iterator iterator = list2.iterator(); iterator.hasNext(); ) {
            if ((Integer) iterator.next() == 3) {
                iterator.remove();
            }
        }
        System.out.println("after remove");
        list2.forEach(System.out::println);
    }
}
