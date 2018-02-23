package com.base.annotation;

import java.lang.reflect.Field;

/**
 * 注解处理器
 *
 * @author ck
 * 2018/2/23 15:06
 */
public class FruitHandler {

    public static void getFruitInfo(Class clazz) {
        String fruitNameStr = "水果名称：";
        String fruitColorStr = "水果颜色：";
        String fruitProviderStr = "供应商信息：";

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                fruitNameStr = fruitNameStr + fruitName.value();
                System.out.println(fruitNameStr);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                fruitColorStr = fruitColorStr + fruitColor.fruitColor().toString();
                System.out.println(fruitColorStr);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                fruitProviderStr = fruitProviderStr + "供应商ID=" + fruitProvider.id() + " 供应商名称=" + fruitProvider.name() + " 供应商地址=" +
                        fruitProvider.address();
                System.out.println(fruitProviderStr);
            }
        }
    }
}
