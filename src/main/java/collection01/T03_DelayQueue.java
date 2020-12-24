package collection01;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T03_DelayQueue {

    static BlockingQueue<Task> queue = new DelayQueue();

    static class Task implements Delayed {

        private String name;
        private long executeTimes;

        Task(String name, long executeTimes) {
            this.name = name;
            this.executeTimes = executeTimes;
        }


        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(executeTimes - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", executeTimes=" + executeTimes +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long o = System.currentTimeMillis();
        Task t1 = new Task("task01", o + 200);
        Task t2 = new Task("task02", o + 1000);
        Task t3 = new Task("task03", o + 5000);
        Task t4 = new Task("task04", o + 2000);
        Task t5 = new Task("task05", o + 500);
        Task t6 = new Task("task06", o + 100);

        queue.put(t1);
        queue.put(t2);
        queue.put(t3);
        queue.put(t4);
        queue.put(t5);
        queue.put(t6);

//        TimeUnit.SECONDS.sleep(5);

        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();





    }
}
