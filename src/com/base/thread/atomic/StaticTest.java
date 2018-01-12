package com.base.thread.atomic;

/**
 * TODO...
 *
 * @author ck
 * @date 2018/1/4 14:29
 */
public class StaticTest {

    private static long count = 0;

    private static long addOne() {
        return ++count;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        if (addOne() == 100) {
                            System.out.println("到了100了");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count = " + count);
    }
}
