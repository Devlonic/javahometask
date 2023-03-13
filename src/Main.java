import java.time.LocalDate;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate isLeapYear = (year)-> (int)year % 4 == 0;

        Duration d = Duration.of(10, ChronoUnit.HOURS);
        System.out.println(isLeapYear.test(2004));
        System.out.println(isLeapYear.test(2005));
        System.out.println(LocalDate.of(2023, 3, 13).);

        BiFunction<LocalDate, LocalDate, Integer> getDaysCount = (LocalDate fromDate, LocalDate toDate)-> {
            return 0;
        };
    }
}
