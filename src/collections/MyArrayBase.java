package collections;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public abstract class MyArrayBase<T extends Number> {
    protected static Random random = new Random();

    // generators
    public static Function<Object, Integer> randomIntGenerator() {
        return (o)-> {
            return random.nextInt(20) - 10;
        };
    }
    // generators
    public static Function<Object, Double> randomDoubleGenerator() {
        return (o)-> {
            return 20.0 * random.nextDouble() - 10.0;
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

    // comparators
    public static Comparator<Integer> integerComparator() {
        return (i1, i2)-> {
            return  i1 < i2 ? -1 : i1 == i2 ? 0 : 1;
        };
    }

    protected void printArray(T[] arr) {
        for (T e: arr) {
            System.out.printf("%s\t", e.toString());
        }
        System.out.println();
    }
    protected double getAverageArray(T[] arr) {
        double accumulator = 0;
        for (T n: arr) {
            double d = n.doubleValue();
            accumulator += d;
        }
        return accumulator / arr.length;
    }
    protected double getAverageArray(T[][] arr) {
        double accumulator = 0;
        for (T[] a: arr) {
            for (T n: a) {
                accumulator += n.doubleValue();
            }
        }
        return accumulator / (arr.length * arr[0].length);
    }

    public abstract void print();

    public abstract T getMin(Comparator<T> comparator);
    public abstract T getMax(Comparator<T> comparator);
    public abstract double getAverage();
    public abstract void sortAsc();
    public abstract void sortDesc();
    public abstract int findIndex(T key);
    public abstract void replace(T oldValue, T newValue);
}
