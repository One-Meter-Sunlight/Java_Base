package com.base.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ck on 2017-09-17.
 */
public class SortTest {
    public static void main(String[] args) {

        List<People> peoples = new ArrayList<>();

        peoples.add(new People(6, "曹洪", 100521, "长安"));
        peoples.add(new People(3, "曹植", 100421, "西安"));
        peoples.add(new People(4, "曹操", 100421, "西安"));
        peoples.add(new People(4, "曹b", 100421, "西安"));
        peoples.add(new People(2, "曹丕", 100421, "西安"));
        peoples.add(new People(1, "夏侯惇", 100520, "许都"));
        peoples.add(new People(5, "夏侯纯", 100520, "许都"));

        // 排序, 注意这里
        List<Integer> list02 = peoples.parallelStream().map(People::getId).collect(Collectors.toList());
        list02.sort((Integer a, Integer b) -> a.compareTo(b));
        list02.sort((Integer a, Integer b) -> a.intValue() - b.intValue());
        list02.stream().forEach(System.out::println);

        System.out.println("=====================基本数据类型排序================");
        ArrayList list03 = new ArrayList<>(Arrays.asList(6, 3, 8, 4, 1, 9, 7, 2, 5));
        list03.sort(Comparator.comparingInt(Integer::intValue));
        list03.stream().forEach(System.out::println);

        System.out.println("=====================引用数据类型排序================");
        peoples.sort(Comparator.comparing(People::getId).thenComparing(People::getName));
        //List<Integer> list01 = peoples.parallelStream().map(People::getId).collect(Collectors.toList());
        List<String> list01 = peoples.parallelStream().map(People::getName).collect(Collectors.toList());
        list01.stream().forEach(System.out::println);

        System.out.println("=====================引用数据类型排序 - 反转================");
        peoples.sort(Comparator.comparing(People::getId).thenComparing(People::getName).reversed());  // 反转
        //List<Integer> list01 = peoples.parallelStream().map(People::getId).collect(Collectors.toList());
        List<String> list04 = peoples.parallelStream().map(People::getName).collect(Collectors.toList());
        list04.stream().forEach(System.out::println);
    }
}
