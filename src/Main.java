import java.util.Arrays;
import java.util.Random;

class Task1 {
    public static void start() {
        int[] arr = new int[10];

        Thread t1 = new Thread(()->{
            System.out.println("t1 start");
            System.out.println("t1 begin");
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                arr[i] = r.nextInt(10);
            }
            System.out.println("filled " + Arrays.toString(arr));
        });

        Thread t2 = new Thread(()->{
            System.out.println("t2 start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2 begin");

            int sum = 0;
            for (var num: arr) {
                sum += num;
            }
            System.out.println("sum is " + sum);
        });
        Thread t3 = new Thread(()->{
            System.out.println("t3 start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t3 begin");

            int avg = 0;
            for (var num: arr) {
                avg += num;
            }
            System.out.println("avg is " + avg / arr.length);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

public class Main {
    public static void main(String[] args) {
        Task1.start();
    }
}
