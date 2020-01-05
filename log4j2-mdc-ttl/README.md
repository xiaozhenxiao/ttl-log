##TransmittableThreadLocal和log4j2集成
TransmittableThreadLocal和log4j2的集成，实现跨线程池的mdc追踪
##使用方法
> 在log4j2.component.properties中加入配置
> log4j2.threadContextMap=com.jd.ttl.log4j2.TtlThreadContextMap

##支持spring AsyncTaskExecutor线程池
###用法
```
AsyncTaskExecutor executor = AsyncTaskExecutorTtlWrapper.wrap(asyncTaskExecutor);
executor.submit(runnable);
```