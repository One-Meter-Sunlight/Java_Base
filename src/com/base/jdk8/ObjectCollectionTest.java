package com.base.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by ck on 2017-09-17.
 */
public class ObjectCollectionTest {

    private List<People> peoples = new ArrayList<>();

    public ObjectCollectionTest() {
        peoples.add(new People(6, "曹洪", 100521, "长安"));
        peoples.add(new People(3, "曹植", 100421, "西安"));
        peoples.add(new People(4, "曹操", 100421, "西安"));
        peoples.add(new People(2, "曹丕", 100421, "西安"));
        peoples.add(new People(1, "夏侯惇", 100520, "许都"));
        peoples.add(new People(5, "夏侯纯", 100520, "许都"));
    }

    public static void main(String[] args) {

        ObjectCollectionTest test = new ObjectCollectionTest();
        for (People people : test.peoples) {
            System.out.println(people.getName());
        }

        System.out.println("----------------jdk8 print 01 内部类----------------");
        List<String> list01 = test.peoples.parallelStream().map(People::getName).collect(Collectors.toList());
        list01.parallelStream().forEach(System.out::println);

    }
}
