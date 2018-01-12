package com.base.thread.printLetters;

/**
 * 测试打印
 *
 * @author ck
 * @date 2017/12/19 11:13
 */
public class TestPrint {

    public static void main(String[] args) {
        Object print = new Object();
        Thread t1 = new Thread(new PrintNumber(print));
        t1.start();

        Thread t2 = new Thread(new PrintLetter(print));
        t2.start();
    }
}
