package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T03_FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(8);
    }
}
