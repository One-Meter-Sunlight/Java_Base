package com.base.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解：水果名称
 *
 * @author ck
 * 2018/2/23 14:47
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitName {

    String value() default "";
}
