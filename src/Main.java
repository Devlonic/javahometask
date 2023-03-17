import java.time.LocalDate;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // task1

        //1
        Predicate isLeapYear = (year)-> (int)year % 4 == 0;

        //2
        BiFunction<Date, Date, Integer> countDaysBetweenDates = (d1, d2)->{
            var millisDiff = d1.getTime() - d2.getTime();
            // compiler should optimize this code
            return (int)((double)millisDiff / (24*60*60*1000)-1);
        };
        System.out.println(countDaysBetweenDates.apply(
                new Date(2023,3,18),
                new Date(1000,3,7)));

        //3

        BiFunction<Date, Date, Integer> countFullWeeksBetweenDates = (d1, d2)->{
            var millisDiff = d1.getTime() - d2.getTime();
            // compiler should optimize this code
            return (int)((double)millisDiff / (7*24*60*60*1000)-1);
        };
        System.out.println(countFullWeeksBetweenDates.apply(
                new Date(2023,3,18),
                new Date(2022,9,7)));

        //4
        // todo
        Function<Date, Integer> dayOfWeek = (d)->{
            return -1;
        };
        System.out.println(dayOfWeek.apply(new Date(2022,9,7)));

        //task2
        //1

    }
}
