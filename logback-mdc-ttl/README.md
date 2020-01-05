#TransmittableThreadLocal和logback集成
TransmittableThreadLocal和logback的集成，实现跨线程池的mdc追踪
##使用方法一
1.在logback.xml中加入监听
> \<contextListener class="com.jd.ttl.logback.TtlMdcListener"/>

2.对线程池进行包装代理
```
 Executor executor = TtlExecutors.getTtlExecutor(executor);
 //正常使用Executor的方法即可
 executor.execute(runnable);
```

或者
```
 ExecutorService executorService = TtlExecutors.getTtlExecutorService(executorService);
 //正常使用ExecutorService的方法即可
 executorService.execute(runnable);
 executorService.submit(callable);
```

##支持spring AsyncTaskExecutor线程池
###用法
```
AsyncTaskExecutor executor = AsyncTaskExecutorTtlWrapper.wrap(asyncTaskExecutor);
executor.submit(runnable);
```
##使用方法二
> 零侵入方式 如想使用此方式切不明白可联系 [wangzhen332](mailto:wangzhen23@jd.com)