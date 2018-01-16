package com.base.Task;

import java.util.concurrent.Callable;

/**
 * 调用任务
 *
 * @author ck
 * @date 2018/1/16 16:30
 */
public class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000 * 10);
        return "call 任务执行...";
    }
}
