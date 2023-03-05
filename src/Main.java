import collections.MyArray;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        // home task 4

        // task1
        MyArray<Integer> arr = new MyArray<Integer>();
        arr.fill(10, MyArray.randomIntGenerator());
        arr.print();

        MyArray<Integer> arr3 = new MyArray<Integer>();
        arr3.fill(4, MyArray.consoleInputIntGenerator());
        arr3.print();

        int min = arr3.getMin(MyArray.integerComparator());
        System.out.println("Min is " + min);

        int max = arr3.getMax(MyArray.integerComparator());
        System.out.println("Max is " + max);

        double avg = arr3.getAverage();
        System.out.println("Avg is " + avg);

        arr3.sortDescEmbedded();
        arr3.print();

        arr3.sortAscEmbedded();
        arr3.print();

        int key = -2;
        int index = arr3.findIndexEmbedded(key);
        System.out.printf("Index of '%s' is '%d'\n", key, index);

        try {
            arr3.replace(key, -22222);
            arr3.print();
        } catch (ArrayStoreException e) {
            System.out.println("ERROR " + e.toString());
        }


        int index2 = arr3.findIndexEmbedded(-22222);
        System.out.printf("Index of '%s' is '%d'\n", -22222, index2);
    }
}
