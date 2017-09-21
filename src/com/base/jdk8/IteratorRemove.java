package com.base.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Describe：如果要删除Collection中的元素的时候，直接调用remove()方法是会报异常的，这里可以调用Iterator的remove()方法，
 * 但是只局限于单线程，在多线程环境下，也还是会报异常的，如果要在多线程环境下使用，那就请使用CopyOnWriteArrayList
 * Created by ck 2017/9/21 15:11
 */
public class IteratorRemove {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            if (integer.intValue() == 2) {
                iterator.remove();
            }
        }

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
