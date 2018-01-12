package com.base.jdk8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Describe：
 * Created by ck 2017/9/25 14:45
 */
public class DateTimeFormatterTest {

    public static void main(String[] args) {

        // LocalDate 2017-09-25
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse("2017-09-25", df);
        System.out.println(localDate);
        System.out.println(df.format(localDate));

        // LocalDateTime 2017-09-25T15:10:23 2017-09-25 15:10:23
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse("2017-09-25 15:10:23", df2);
        System.out.println(localDateTime);
        System.out.println(df2.format(localDateTime));

        System.out.println(df2.format(LocalDateTime.now().plusDays(1)));

    }

}
