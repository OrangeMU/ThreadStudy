package collection01;

import java.util.PriorityQueue;

public class T04_PriorityQueue {
    public static void main(String[] args) {
        var str = "123";
        System.out.println(str);

        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.offer("a");
        queue.offer("e");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.poll());
        }
    }
}
