package com.base.jdk8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ck on 2017-09-18.
 */
public class CollectionTest {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张飞");
        map.put(2, "关羽");
        map.put(3, "曹操");

        List<People> peoples = new ArrayList<>();

        peoples.add(new People(6, "曹洪", 100521, "长安"));
        peoples.add(new People(3, "曹植", 100421, "西安"));
        peoples.add(new People(4, "曹操", 100421, "西安"));
        peoples.add(new People(8, "曹b", 100421, "西安"));
        peoples.add(new People(2, "曹丕", 100421, "西安"));
        peoples.add(new People(1, "夏侯惇", 100520, "许都"));
        peoples.add(new People(5, "夏侯纯", 100520, "许都"));

        // 获得ID集合
        List<Integer> idList = peoples.stream().map(People::getId).collect(Collectors.toList());
        idList.stream().forEach(System.out::println);

        System.out.println("-------------------------------------");

        // 对象转换map
        Map<Integer, String> idAndNameMap = peoples.stream().collect(Collectors.toMap(People::getId, People::getName));
        System.out.println(idAndNameMap);
        Map<Integer, String> idAndNameMap2 = peoples.stream().collect(Collectors.toMap(x-> x.getId(), y-> y.getName()));
        System.out.println(idAndNameMap2);
        System.out.println("-------------------------------------");

        // 分组
        Map<Integer, List<People>> idAndNameMap3 = peoples.stream().collect(Collectors.groupingBy(x -> x.getId()));
        System.out.println(idAndNameMap3);
        System.out.println("-------------------------------------");

        // map过滤
        Map<Integer, String> idAndNameMap4 = peoples.stream().filter(x -> x.getName().equals("夏侯惇")).collect(Collectors.toMap(x->
                        x.getId(), y-> y.getName()));
        System.out.println(idAndNameMap4);
        System.out.println("-------------------------------------");

        // list和map的集成过滤
        List<Integer> idList2 = peoples.stream().filter(
                x -> map.containsKey(x.getId())
        ).map(People::getId).collect(Collectors.toList());
        System.out.println(idList2);
        System.out.println("-------------------------------------");

    }
}
