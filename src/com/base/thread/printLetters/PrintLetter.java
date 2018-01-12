package com.base.thread.printLetters;

/**
 * 打印大写字母
 *
 * @author ck
 * @date 2017/12/19 11:09
 */
public class PrintLetter implements Runnable {

    private Object obj;

    public PrintLetter(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            try {
                for (int i = 0; i < 26; i++) {
                    System.out.print((char)(i + 'A'));
                    obj.notifyAll();
                    obj.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
