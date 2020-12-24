package collection01;

public class T05_CAS {
    //自旋交替打印
    enum ReadyToRun{T1, T2};

    //保证线程间的可见性
    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        char aI[] = "ABCDEFG".toCharArray();
        char nI[] = "1234567".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                while (r != ReadyToRun.T1) {}
                System.out.println(c);
                r = ReadyToRun.T2;
            }
        }).start();

        new Thread(() -> {
            for (char c : nI) {
                while (r != ReadyToRun.T2) {}
                System.out.println(c);
                r = ReadyToRun.T1;
            }
        }).start();
    }
}
