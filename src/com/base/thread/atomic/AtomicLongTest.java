package com.base.thread.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * volatile 能保证线程可见性，但是不能保证原子性， Atomic可以保证原子性
 * 原因：取值是线程可见性保证的， 但是A线程当取到最新的值10时，没有cpu资源， 不能累加， 而B线程获得了cpu资源，也取到了
 * 最新的值10，它进行了累加，变成了11， 而A线程之后再进行累加，也变成了11， 写入公共内存， 这样就导致了原子性没有得到保证；
 * <p>
 * 因为CAS是基于乐观锁的，也就是说当写入的时候，如果寄存器旧值已经不等于现值，说明有其他CPU在修改，那就继续尝试。所以这就保证了操作的原子性。
 *
 * @author ck
 * @date 2018/1/4 14:29
 */
public class AtomicLongTest {

    private static AtomicLong counter = new AtomicLong(0);

    private static long addOne() {
        return counter.incrementAndGet();
    }

    private static long addValue(long value) {
        return counter.addAndGet(value);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        if (addValue(5) == 100) {
                            System.out.println("到了100了");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

}
