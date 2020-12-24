package future02;

import java.util.concurrent.*;

public class T06_00_HelloThreadPool {


    public static void main(String[] args) {

        //线程池的7个参数
        // 1.核心线程数
        // 2.最大线程数
        // 3.存活时间
        // 4.存活时间单位
        // 5.任务队列
        // 6.线程工厂
        // 7.拒绝策略
        //   --Abort: 抛异常
        //   --Discard: 扔掉，不抛异常
        //   --DiscardOldest: 扔掉排队时间最久的
        //   --CallRuns: 调用者处理任务

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 2,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
