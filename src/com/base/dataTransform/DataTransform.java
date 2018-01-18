package com.base.dataTransform;

/**
 * 数据转换
 *
 * @author ck
 * @date 2018/1/17 18:55
 */
public class DataTransform {

    public static void main(String[] args) {
        // byte -> int
        byte a = 7;
        byte b = 0;
        byte c = -7;

        int aa = 7;
        int bb = 0;
        int cc = -7;
        System.out.println((int) a);
        System.out.println((int) b);
        System.out.println((int) c);

        System.out.println((int) a == aa);
        System.out.println((int) b == bb);
        System.out.println((int) c == cc);

        System.out.println(a & 0xFF);
        System.out.println(b & 0xFF);
        System.out.println(c & 0xFF);

    }

}
