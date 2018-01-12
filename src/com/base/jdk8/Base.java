package com.base.jdk8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ck on 2017-09-17.
 */
public class Base {

    public static void main(String[] args) {

        ArrayList list = new ArrayList<>(Arrays.asList(6, 3, 8, 4, 1, 9, 7, 2, 5));

        // 求极限值
        int max = (int) list.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(max);

        // 求和
        int sum = (int) list.stream().reduce(0, (a, b) -> (int) a + (int) b);
        System.out.println(sum);

        // 归并
        int sum2 = Stream.of(1, 2, 3).reduce(0, (a, b) -> (int) a + (int) b);
        System.out.println(sum2);

        System.out.println("--------------------flatMap----------------------");
        // flatMap 合并
        List<Integer> list1 = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5, 6)).flatMap(number -> number.stream()).collect
                (Collectors.toList());
        list1.stream().forEach(a -> System.out.println(a));

    }
}
