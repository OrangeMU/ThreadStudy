package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T05_ParallelStreamAPI {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            nums.add(1000000 + r.nextInt(1000000));
        }

//        System.out.println(nums);

        long start = System.currentTimeMillis();
        nums.forEach(e -> isPrime(e));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        nums.parallelStream().forEach(e ->isPrime(e));
        end = System.currentTimeMillis();

        System.out.println(end - start);


    }

    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
