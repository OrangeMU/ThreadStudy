package collection01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T06_BlockingPrinter {

    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);


    public static void main(String[] args) {

        String[] cI = "ABCEDFG".split("");
        String[] nI = "1234567".split("");

        new Thread(() -> {
            for (int i = 0; i < cI.length; i++) {
                try {
                    System.out.println(q1.take());
                    q2.put(nI[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < nI.length; i++) {
                try {
                    q1.put(cI[i]);
                    System.out.println(q2.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
