Callable -> Runnable + return
Future -> 存储执行的将来才会产生的结果
FutureTask -> Future + Runnable
CompletableFuture管理多个Future的结果

线程池
 * ThreadPoolExecutor
 * ForkJoinPool
    - 分解总的任务
    - 用很少的线程可以执行很多的任务（子任务） TPE做不到先执行子任务
    - CPU密集型