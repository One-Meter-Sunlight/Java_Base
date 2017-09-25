package com.base.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Describe：弱引用
 * 引用类型：
 * 1、强引用
 * 2、软引用
 * 3、弱引用  threadLocal 底层是采用了弱引用的技术，主要目的是以空间换时间；
 * 4、虚引用
 * Created by ck 2017/9/25 14:31
 */
public class WeakReferenceTest {

    /**
     * 线程安全
     */
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    private static final ThreadLocal<DateFormat> df2 = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    private static String paserTime(Date date) {
        return df.get().format(date);
    }

    private static String paserTime2(Date date) {
        return df2.get().format(date);
    }

    public static void main(String[] args) {

        // 格式化时间
        Date date = new Date();
        System.out.println(paserTime(date));
        System.out.println(paserTime2(date));
    }
}
