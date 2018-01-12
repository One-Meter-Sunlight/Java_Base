package com.base.jdk8;

/**
 * 移位运算
 *
 * @author ck
 * @date 2017/12/26 14:24
 */
public class ShiftingCalc {

    public static void main(String[] args) {
        int a = 8;
        System.out.println(a >> 3);  // 右移动1位 = 除以2的1次方
        System.out.println(a >>> 3); // 无符号右移，忽略符号位，空位都以0补齐
    }
}
