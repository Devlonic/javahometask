import java.time.LocalDate;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Division {
    private int numerator;
    private int denominator;

    public Division(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}

public class Main {
    public static void main(String[] args) {
        // task1

        //1
        Predicate isLeapYear = (year) -> (int) year % 4 == 0;

        //2
        BiFunction<Date, Date, Integer> countDaysBetweenDates = (d1, d2) -> {
            var millisDiff = d1.getTime() - d2.getTime();
            // compiler should optimize this code
            return (int) ((double) millisDiff / (24 * 60 * 60 * 1000) - 1);
        };
        System.out.println(countDaysBetweenDates.apply(
                new Date(2023, 3, 18),
                new Date(1000, 3, 7)));

        //3

        BiFunction<Date, Date, Integer> countFullWeeksBetweenDates = (d1, d2) -> {
            var millisDiff = d1.getTime() - d2.getTime();
            // compiler should optimize this code
            return (int) ((double) millisDiff / (7 * 24 * 60 * 60 * 1000) - 1);
        };
        System.out.println(countFullWeeksBetweenDates.apply(
                new Date(2023, 3, 18),
                new Date(2022, 9, 7)));

        //4
        // todo
        Function<Date, Integer> dayOfWeek = (d) -> {
            return -1;
        };
        System.out.println(dayOfWeek.apply(new Date(2022, 9, 7)));

        //task2
        //1

        BiFunction<Division, Division, Double> sum = (d1, d2) -> {
            if (d1.getDenominator() == d2.getDenominator())
                return (d1.getNumerator() + d2.getNumerator()) / ((double) d1.getDenominator());

            throw new RuntimeException("Not implemented");
        };

        System.out.println(sum.apply(new Division(2, 3), new Division(1, 3)));

        //2
        BiFunction<Division, Division, Double> substraction = (d1, d2) -> {
            if (d1.getDenominator() == d2.getDenominator())
                return (d1.getNumerator() - d2.getNumerator()) / ((double) d1.getDenominator());

            throw new RuntimeException("Not implemented");
        };

        System.out.println(substraction.apply(new Division(5, 3), new Division(5, 3)));

        //3
        BiFunction<Division, Division, Double> multiplication = (d1, d2) -> {
            return (d1.getNumerator() * d2.getNumerator()) / (double) (d1.getDenominator() * d2.getDenominator());
        };

        System.out.println(multiplication.apply(new Division(2, 3), new Division(1, 2)));

        //4
        BiFunction<Division, Division, Double> division = (d1, d2) -> {
            return (d1.getNumerator() * d2.getDenominator()) / (double) (d1.getDenominator() * d2.getNumerator());
        };

        System.out.println(division.apply(new Division(4, 15), new Division(2, 3)));

        //task3
        FourGetter<Integer> min = (v1, v2, v3, v4) -> {
            return Stream.builder().add(v1).add(v2).add(v3).add(v4).build().mapToInt(v -> (int) v).min().getAsInt();
        };

        System.out.println(min.get(4, 6, -2, 55));

        FourGetter<Integer> max = (v1, v2, v3, v4) -> {
            return Stream.builder().add(v1).add(v2).add(v3).add(v4).build().mapToInt(v -> (int) v).max().getAsInt();
        };

        System.out.println(max.get(4, 6, -2, 55));

        //task4
        int[] array = new int[]{
                -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 5
        };
        int notEquals = 5;

        int rangeA = -2;
        int rangeB = 2;

        System.out.println();

        // (-endless ; +endless)
        System.out.println(getMySum(array, (i)->true));

        // (-endless ; notEquals) U (notEquals ; +endless)
        System.out.println(getMySum(array, (i)->i != notEquals));

        // (-endless ; rangeA) U (rangeB ; +endless)
        System.out.println(getMySum(array, (i)-> i < rangeA && i > rangeB));

        // (0 ; +endless)
        System.out.println(getMySum(array, (i)-> i > 0));

        // (-endless ; 0)
        System.out.println(getMySum(array, (i)-> i < 0));
    }

    private static long getMySum(int[] array, Predicate<Integer> predicate) {
        long result = 0;
        for (var e : array) {
            if (predicate.test(e))
                result += e;
        }
        return result;
    }
}

interface FourGetter<T> {
    T get(T v1, T v2, T v3, T v4);
}