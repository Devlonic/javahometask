import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Object locker = new Object();

        Thread t1 = new Thread(()->{
            synchronized (locker) {
                System.out.println("Thread 1 begin");
                System.out.println("Thread 1 start");
                Random r = new Random();
                for (int i = 0; i < 10; i++) {
                    arr[i] = r.nextInt(10);
                }
                System.out.println("filled " + Arrays.toString(arr));
                locker.notify();
            }

        });
        Thread t2 = new Thread(()->{
            synchronized (locker) {
                System.out.println("Thread 2 begin");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread 2 start");
                }


                int sum = 0;
                for (var num: arr) {
                    sum += num;
                }
                System.out.println("sum is " + sum);
            }

        });
        Thread t3 = new Thread(()->{
            synchronized (locker) {
                System.out.println("Thread 3 begin");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread 3 start");
                }

                int avg = 0;
                for (var num: arr) {
                    avg += num;
                }
                System.out.println("avg is " + avg / arr.length);
            }

        });

        t1.start();
        t2.start();
        t3.start();
    }
}
