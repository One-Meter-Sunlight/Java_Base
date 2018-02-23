package com.base.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解：供应商信息
 *
 * @author ck
 * 2018/2/23 15:37
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitProvider {

    /**
     * 供应商ID
     *
     * @return
     */
    int id() default -1;

    /**
     * 供应商名称
     *
     * @return
     */
    String name() default "";

    /**
     * 供应商地址
     *
     * @return
     */
    String address() default "";
}
