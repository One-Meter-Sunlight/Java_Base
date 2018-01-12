package com.base.jdk8.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TODO...
 *
 * @author ck
 * @date 2018/1/5 15:23
 */
public class DateUtil {

    public static LocalDateTime getLocalDateTime(String dateString) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime lo = LocalDateTime.parse(dateString, df);
        return lo;
    }

    public static String addDays(LocalDateTime localDateTime, long num) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(localDateTime.plusDays(num));
    }

    public static String getNowDateTime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(LocalDateTime.now());
    }

    public static void main(String[] args) {
        System.out.println(getNowDateTime());
        System.out.println(addDays(LocalDateTime.now(), 5));
        System.out.println(getLocalDateTime("2018-01-05 15:25:52"));
    }
}
