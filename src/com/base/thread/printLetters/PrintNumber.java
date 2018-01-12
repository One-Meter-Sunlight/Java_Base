package com.base.thread.printLetters;

/**
 * 打印数字
 *
 * @author ck
 * @date 2017/12/19 11:09
 */
public class PrintNumber implements Runnable {

    private Object obj;

    public PrintNumber(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                for (int i = 1; i < 53; i++) {
                    System.out.print(i);
                    if (i % 2 == 0) {
                        obj.notifyAll();
                        obj.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
