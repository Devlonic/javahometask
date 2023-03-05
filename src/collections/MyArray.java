package collections;

import java.util.*;
import java.util.function.Function;

public class MyArray<T extends Number> {
    private T[] arr = null;

    private static Random r = new Random();

    // generators
    public static Function<Object, Integer> randomIntGenerator() {
        return (o)-> {
            return r.nextInt(20) - 10;
        };
    }
    public static Function<Object, Integer> consoleInputIntGenerator() {
        return (o)-> {
            Scanner s = new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("Enter number:\t");
                    return Integer.parseInt(s.nextLine());
                } catch (NumberFormatException e) {
                    // no return
                    System.out.println("Enter valid number");
                }
            }
        };
    }

    //    public static Function<Object, String> randomStringGenerator(int length) {
//        return (o)-> {
//            StringBuilder sb = new StringBuilder(length);
//            int min = (int)'A';
//            int max = (int)'Z';
//            for (int i = 0; i < length; i++) {
//                char c = (char) (r.nextInt(max - min) + min);
//                sb.append(c);
//            }
//            return sb.toString();
//        };
//    }

    // comparators
    public static Comparator<Integer> integerComparator() {
        return (i1, i2)-> {
            return  i1 < i2 ? -1 : i1 == i2 ? 0 : 1;
        };
    }

    // averagers


    public void fill(int count, Function<Object, T> generator) {
        this.arr = (T[]) new Number[count];
        for (int i = 0; i < count; i++) {
            this.arr[i] = generator.apply(null);
        }
    }
    public void fillEmbedded(int count, T value) {
        this.arr = (T[]) new Number[count];
        Arrays.fill(arr, value);
    }

    public void print() {
        for (T e: this.arr) {
            System.out.printf("%s ", e.toString());
        }
        System.out.println();
    }

    public T getMin(Comparator<T> comparator) {
        return Arrays.stream(arr).min(comparator).orElse(null);
    }
    public T getMax(Comparator<T> comparator) {
        return Arrays.stream(arr).max(comparator).orElse(null);
    }
    public double getAverage() {
        double accumulator = 0;
        for (T n: arr) {
            double d = n.doubleValue();
            accumulator += d;
        }
        return accumulator / arr.length;
    }

    public void sortAsc() {
        boolean wasChanged = false;
        do {
            wasChanged = false; // reset state
            for (int i = 0; i < arr.length-1; i++) {
                double n1 = arr[i].doubleValue();
                double n2 = arr[i+1].doubleValue();
                if(n1 > n2) {
                    T buffer = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buffer;
                    wasChanged = true;
                }
            }
        } while (wasChanged);
    }
    public void sortAscEmbedded() {
        Arrays.sort(this.arr);
    }

    public void sortDescEmbedded() {
        Arrays.sort(this.arr, Collections.reverseOrder());
    }

    public int findIndexEmbedded(T key) {
        return Arrays.binarySearch(arr, key);
    }

    public void replace(T oldValue, T newValue) {
        int index = findIndexEmbedded(oldValue);
        if(index == -1)
            throw new ArrayStoreException("Array doesn't contains oldValue");

        arr[index] = newValue;
    }
}
