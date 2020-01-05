package com.jd.ttl.threadpool;

import com.jd.jst.enhance.ttl.TtlCallable;
import com.jd.jst.enhance.ttl.TtlRunnable;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * spring AsyncTaskExecutor ttl
 * @author wangzhen23
 * @date 2019/7/11.
 */
public class AsyncTaskExecutorTtlWrapper  implements AsyncTaskExecutor {
    private AsyncTaskExecutor asyncTaskExecutor;

    AsyncTaskExecutorTtlWrapper(AsyncTaskExecutor asyncTaskExecutor) {
        this.asyncTaskExecutor = asyncTaskExecutor;
    }

    public static AsyncTaskExecutorTtlWrapper wrap(AsyncTaskExecutor asyncTaskExecutor){
        return new AsyncTaskExecutorTtlWrapper(asyncTaskExecutor);
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        this.asyncTaskExecutor.execute(TtlRunnable.get(task), startTimeout);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return this.asyncTaskExecutor.submit(TtlRunnable.get(task));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return this.asyncTaskExecutor.submit(TtlCallable.get(task));
    }

    @Override
    public void execute(Runnable task) {
        this.asyncTaskExecutor.execute(TtlRunnable.get(task));
    }
}
