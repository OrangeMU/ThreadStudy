package future02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class T01_01_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //FutureTask 实现了 RunnableFuture==>Runnable、Future，所以FutureTask既可以当作一个任务，又可以当一个返回结果
        //执行完任务放在自己这儿

        //ForkJoinPool WorkStealingPool 都需要使用 FutureTask

        //使用Callable/Runnable时，想要返回结果时，需要在外面再定义一个Future

        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });
        new Thread(task).start();

        System.out.println(task.get());
    }
}
