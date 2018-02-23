package com.base.thread.printLetters;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Locks
 *
 * @author ck
 * @date 2017/12/19 14:42
 */
public class LocksTest {

    // true 公平锁， false 非公平锁（默认）
    private Lock lock = new ReentrantLock(false);

    /**
     * 需要主动释放锁，并且发生异常时，不自动释放锁；
     * 未获得锁的线程会阻塞执行；
     *
     * @param id
     */
    public void insert(Thread id) {
        lock.lock();
        try {
            System.out.println(id + " 获得锁");
            if (id != null) {
                System.out.println(id + " 完成任务");
            }
        } catch (Exception e) {
            System.out.println(id + " 发生异常");
        } finally {
            System.out.println(id + " 释放锁");
            lock.unlock();
        }
    }

    /**
     * 尝试获取锁，如果获取到了则返回true，没有获取到则返回false，发生异常时，也不会主动释放锁；
     *
     * @param id
     */
    public void update(Thread id) {
        if (lock.tryLock()) {
            try {
                System.out.println(id + " update获得锁");
                if (id != null) {
                    System.out.println(id + " update完成任务");
                }
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println(id + " update发生异常");
            } finally {
                System.out.println(id + " update释放锁");
                lock.unlock();
            }
        } else {
            System.out.println(id + " update未完成任务");
        }
    }

    /**
     * 和lock.tryLock()区别在于这个方法在拿不到锁时会等待一定的时间，在时间期限之内如果还拿不到锁，就返回false；
     * MILLISECONDS 毫秒
     * MICROSECONDS 微秒
     *
     * @param id
     */
    public void select(Thread id, int index) {
        try {
            if (lock.tryLock(8000, TimeUnit.MILLISECONDS)) {
                System.out.println(id + " update获得锁");
                if (id != null) {
                    System.out.println(id + " update完成任务");
                }
                Thread.sleep(500);
                if(index == 5) {
                    throw new RuntimeException();
                }
                lock.unlock();
            } else {
                System.out.println(id + " update未获得锁，--------未完成任务");
            }
        } catch (Exception e) {
            System.out.println(id + " 发生异常 == index = " +  index);
            lock.unlock();
        } finally {
            //
        }
    }

    public void delete(Thread id) {
        try {
            lock.lockInterruptibly();
            int a = 1, b = 0;
            int c = a/b;
            if (id != null) {
                System.out.println(id + " 完成任务");
            }
        } catch (Exception e) {
            System.out.println(id + " 发生异常");
        } finally {
            System.out.println(id + " 发生异常,释放锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final LocksTest test = new LocksTest();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.select(Thread.currentThread(), index);
                }
            }).start();
        }
    }
}
