package collections;

import java.util.*;
import java.util.function.Function;

public class MyArray<T extends Number> extends MyArrayBase<T> {
    private T[] arr = null;

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

    public void fill(int count, Function<Object, T> generator) {
        this.arr = (T[]) new Number[count];
        for (int i = 0; i < count; i++) {
            this.arr[i] = generator.apply(null);
        }
    }

    @Override
    public void print() {
        super.printArray(this.arr);
    }
    @Override
    public T getMin(Comparator<T> comparator) {
        return Arrays.stream(arr).min(comparator).orElse(null);
    }
    @Override
    public T getMax(Comparator<T> comparator) {
        return Arrays.stream(arr).max(comparator).orElse(null);
    }
    @Override
    public double getAverage() {
        return super.getAverageArray(arr);
    }
    @Override
    public void sortAsc() {
        Arrays.sort(this.arr);
    }
    @Override
    public void sortDesc() {
        Arrays.sort(this.arr, Collections.reverseOrder());
    }
    @Override
    public int findIndex(T key) {
        return Arrays.binarySearch(arr, key);
    }
    @Override
    public void replace(T oldValue, T newValue) {
        int index = findIndex(oldValue);
        if(index == -1)
            throw new ArrayStoreException("Array doesn't contains oldValue");

        arr[index] = newValue;
    }
}
