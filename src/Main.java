
import org.w3c.dom.ranges.RangeException;

import java.io.PrintStream;
import java.util.*;

public class Main {
    //task1
    static void task1() {
        System.out.println("""
                \"Your time is limited,
                    so don`t waste it
                        living someone else`s life\"
                            Steve Jobs
                """);
    }

    //task2
    static void task2() {
        int x, perc;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number:\t");
        x = in.nextInt();
        System.out.println("Enter percent:\t");
        perc = in.nextInt();
        System.out.println("Result: " + (perc*0.01)*x);
    }

    //task3
    static void task3() {
        int num1, num2, num3, res = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter numbers:\t");
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();

        res += num1 * 100 + num2 * 10 + num3;

        System.out.println("Result:\t" + res);
    }

    //task4
    static void task4() {
        int num, res = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number[100000;999999]:\t");
        num = in.nextInt();
        if(num < 100000 || num > 999999) {
            System.out.println("Number must be in range [100000;999999]");
            return;
        }

        int numeric1 = (num % 1000000)/100000;
        int numeric2 = (num % 100000)/10000;
        int numeric3 = (num % 10000)/1000;
        int numeric4 = (num % 1000)/100;
        int numeric5 = (num % 100)/10;
        int numeric6 = (num % 10);

        res += numeric6 * 100000;
        res += numeric5 * 10000;
        res += numeric3 * 1000;
        res += numeric4 * 100;
        res += numeric2 * 10;
        res += numeric1;

        System.out.println("Result:\t" + res);

        // 100000 -> 000001
        // 202001 -> 102002
        // 101010 -> 011001
    }

    // task5
    static String monthNumberToSeasonString(int number) {
        final String winter = "Winter";
        final String spring = "Spring";
        final String summer = "Summer";
        final String autumn = "Autumn";

        String month = null;

        switch (number) {
            case 12:
            case 1:
            case 2: month = winter; break;
            case 3:
            case 4:
            case 5: month = spring; break;
            case 6:
            case 7:
            case 8: month = summer; break;
            case 9:
            case 10:
            case 11: month = autumn; break;
            default: {
                throw new RangeException((short)0, "Number must be in range [1;12]");
            }
        }
        return month;
    }
    static void task5() {


        int num, res = 0;
        String month = "";
        Scanner in = new Scanner(System.in);

//        System.out.println("Enter month:\t");
//        num = in.nextInt();
        for (int i = 0; i < 16; i++) {
            try {
                System.out.printf("%d Season is:\t%s\n", i, monthNumberToSeasonString(i));
            } catch (RangeException e) {
                System.out.printf("%d Season is:\t%s\n", i, "ERROR");
            }
        }
    }

    //task6
    enum Measure {
        Miles, Inches, Yards
    }
    static float convertMetersToMeasure(float meters, Measure measure) {
        final float MILES_TO_METERS = 0.00062137f;
        final float INCHES_TO_METERS = 39.3700787f;
        final float YARDS_TO_METERS = 1.0936133f;

        float res = 0;

        switch (measure) {
            case Miles: res = meters * MILES_TO_METERS; break;
            case Inches: res = meters * INCHES_TO_METERS; break;
            case Yards: res = meters * YARDS_TO_METERS; break;
            default: {
                throw new RangeException((short)0, "Wrong measure");
            }
        }
        return res;
    }

    static void task6() {
        Measure action;
        float meters = 0, res = 0;

        // get meters
        Scanner in = new Scanner(System.in);
        System.out.println("Enter meters:\t");
        meters = in.nextFloat();

        // print all available measures and get one from user
        var measures = Measure.values();
        System.out.println("Available measures");
        for (var m: measures) {
            System.out.printf("%d - %s\n", m.ordinal(), m.toString());
        }
        System.out.println("Enter action:\t");
        var i = in.nextInt();
        if(i > measures.length-1 || i < 0) {
            throw new RangeException((short)0, "Wrong measure");
        }
        action = measures[i];

        // calculate result
        res = convertMetersToMeasure(meters, action);

        // print output
        System.out.printf("Result is: %f", res);
    }

    // task7
    static void task7() {
        int fromNum, toNum;

        // get numbers
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers:\t(from to):");
        fromNum = in.nextInt();
        toNum = in.nextInt();

        // range normalization
        if(fromNum > toNum) {
            var buf = fromNum;
            fromNum = toNum;
            toNum = buf;
        }

        // print every odd number
        // range is (fromNum; toNum). NOT [fromNum; toNum]
        for (int i = fromNum+1; i < toNum; i++) {
            if(i % 2 == 1)
                System.out.printf("%d ", i);
        }
        System.out.println();
    }

    // task8
    static  void task8() {
        int fromNum, toNum;

        // get numbers
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers:\t(from to):");
        fromNum = in.nextInt();
        toNum = in.nextInt();

        // range normalization
        if(fromNum > toNum) {
            var buf = fromNum;
            fromNum = toNum;
            toNum = buf;
        }

        // print table
        // range is [fromNum; toNum]
        for (int x = fromNum; x <= toNum; x++) {
            for (int y = 1; y < 10; y++) {
                System.out.printf("%d*%d=%d", x, y, x*y);
                if(y < 9)
                    System.out.print("\t");
            }
            System.out.println();

        }
    }

    // task9
    static  void task9() {
        int[] nums = new int[10];
        int fromNum = -10, toNum = 10;
        Random r = new Random();

        // generate and print elements at range [fromNum; toNum]
        for (int i = 0; i < 10; i++) {
            nums[i] = r.nextInt((toNum)*2) - Math.abs(fromNum);
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();

        // calculate results;
        int minElement, maxElement, countOfNegativeElements = 0, countOfPositiveElements = 0, countOfZeros = 0;

        minElement = Arrays.stream(nums).min().getAsInt();
        maxElement = Arrays.stream(nums).max().getAsInt();
        for (var x : nums) {
            if(x < 0) countOfNegativeElements++;
            else if(x > 0) countOfPositiveElements++;
            else countOfZeros++;
        }

        // print results
        System.out.printf("""
                minElement = %d
                maxElement = %d
                countOfNegativeElements = %d
                countOfPositiveElements = %d
                countOfZeros = %d
                """, minElement, maxElement, countOfNegativeElements, countOfPositiveElements, countOfZeros);
    }

    // task10
    static  void task10() {
        int[] nums = new int[10];
        int fromNum = -10, toNum = 10;
        Random r = new Random();

        // generate and print elements at range [fromNum; toNum]
        for (int i = 0; i < 10; i++) {
            nums[i] = r.nextInt((toNum)*2) - Math.abs(fromNum);
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();

        int[] onlyNumbersEven, onlyNumbersOdd, onlyNumbersNegative, onlyNumbersPositive;
        onlyNumbersEven = Arrays.stream(nums).filter(x->x%2 ==0).toArray();
        onlyNumbersOdd = Arrays.stream(nums).filter(x->x%2 ==1).toArray();
        onlyNumbersNegative = Arrays.stream(nums).filter(x->x<0).toArray();
        onlyNumbersPositive = Arrays.stream(nums).filter(x->x>0).toArray();

        System.out.println("\nEven:");
        Arrays.stream(onlyNumbersEven).forEach(x-> System.out.printf("%d ", x));

        System.out.println("\nOdd:");
        Arrays.stream(onlyNumbersOdd).forEach(x-> System.out.printf("%d ", x));

        System.out.println("\nNegative:");
        Arrays.stream(onlyNumbersNegative).forEach(x-> System.out.printf("%d ", x));

        System.out.println("\nPositive:");
        Arrays.stream(onlyNumbersPositive).forEach(x-> System.out.printf("%d ", x));
    }

    // task11
    enum Direction {
        Horizontal, Vertical
    }

    static  void printHorizontalChar(PrintStream stream, char symbol, int totalLength, int curLength) {
        stream.print(symbol);
    }
    static  void printVerticalChar(PrintStream stream, char symbol, int totalLength, int curLength) {
        stream.print(symbol);
        if(curLength < totalLength-1)
            System.out.println();

    }
    static  void printLine(PrintStream stream, int length, Direction direction, char symbol) {
        System.out.println();
        for (int i = 0; i < length; i++) {
            switch (direction) {
                case Horizontal -> printHorizontalChar(stream, symbol, length, i);
                case Vertical -> printVerticalChar(stream, symbol, length, i);
            }
        }
    }
    static  void task11() {
        printLine(System.out, 12, Direction.Horizontal, '*');
        printLine(System.out, 3, Direction.Vertical, '#');
        printLine(System.out, 12, Direction.Horizontal, '*');
    }

    // task12
    enum SortMethod {
        Ascending, Descending
    }
    static  void sortArrayByDesc(int[] arr) {
        boolean wasChanged = false;
        do {
            wasChanged = false;
            for (int i = 0; i < arr.length; i++) {
                if(i < arr.length - 1 && arr[i] > arr[i+1]) {
                    var buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                    wasChanged = true;
                }
            }
        } while (wasChanged == true);
    }
    static  void sortArrayByAsc(int[] arr) {
        boolean wasChanged = false;
        do {
            wasChanged = false;
            for (int i = 0; i < arr.length; i++) {
                if(i < arr.length - 1 && arr[i] < arr[i+1]) {
                    var buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                    wasChanged = true;
                }
            }
        } while (wasChanged == true);
    }
    static  void sortArray(int[] arr, SortMethod method) {
        switch (method) {
            case Ascending -> sortArrayByAsc(arr);
            case Descending -> sortArrayByDesc(arr);
        }
    }
    static  void task12() {
        int[] nums = new int[10];
        int fromNum = -10, toNum = 10;
        Random r = new Random();

        // generate and print elements at range [fromNum; toNum]
        for (int i = 0; i < 10; i++) {
            nums[i] = r.nextInt((toNum)*2) - Math.abs(fromNum);
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();

        sortArray(nums, SortMethod.Descending);

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }

        sortArray(nums, SortMethod.Ascending);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        try {
//            task6();
//        } catch (RangeException e) {
//            System.out.println(e.toString());
//        }
//        task7();
//        task8();
//            task9();
//            task10();
//        task11();
        task12();
    }
}
