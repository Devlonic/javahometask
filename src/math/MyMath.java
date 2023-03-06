package math;

import java.util.Comparator;

public interface MyMath<T extends Number> {
    T getMin(Comparator<T> comparator);
    T getMax(Comparator<T> comparator);
    double getAverage();
}

