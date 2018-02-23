package com.base.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解：水果颜色
 *
 * @author ck
 * 2018/2/23 14:47
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitColor {

    public enum Color {BLUE, RED, GREEN};

    Color fruitColor() default Color.RED;
}
