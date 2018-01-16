package com.base.Task;

import java.util.concurrent.*;

/**
 * Future task 测试
 *
 * @author ck
 * @date 2018/1/16 16:26
 */
public class FutureTest {

    public static void main(String[] args) {
        // 创建线程池(向下转型)
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 5,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        Future<String> future = threadPoolExecutor.submit(new CallableTask());
        System.out.println("我可以做其他事情了...");

        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭任务
        System.out.println("关闭任务...");
        future.cancel(true);

    }
}
