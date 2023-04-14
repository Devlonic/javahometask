import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Task1 {
    public static void start() {
        String file1path = "./dir/file1.txt";
        String file2path = "./dir/file2.txt";

        try {
            Scanner s1 = new Scanner(new File(file1path));
            Scanner s2 = new Scanner(new File(file2path));
            while (s1.hasNextLine() || s2.hasNextLine()) {
                var row1 = s1.nextLine();
                var row2 = s2.nextLine();

                if(!row1.equals(row2))
                    System.out.printf("%s:\n%s\n%s:\n%s\n\n\n", file1path, row1, file2path, row2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task2 {
    public static void start() {
        String file1path = "./dir/file1.txt";

        try {
            Scanner s1 = new Scanner(new File(file1path));
            String maxString = "";
            while (s1.hasNextLine()) {
                var row1 = s1.nextLine();
                if(row1.length() > maxString.length())
                    maxString = row1;
            }
            System.out.println(maxString.length() + " " + maxString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task3 {
    public static void start() {
        String file1path = "./dir/file3.txt";

        try {
            Scanner s1 = new Scanner(new File(file1path));
            System.out.printf("                \t\tMIN\tMAX\tSUM\n");
            List<Integer> minimums = new ArrayList<>();
            List<Integer> maximums = new ArrayList<>();
            int totalSum = 0;
            while (s1.hasNextLine()) {
                var row1 = s1.nextLine();
                var rawNumbers = Arrays.stream(row1.split(" ")).map(s-> Integer.valueOf(s)).collect(Collectors.toList());
                var max = rawNumbers.stream().mapToInt(Integer::intValue).max().getAsInt();
                var min = rawNumbers.stream().mapToInt(Integer::intValue).min().getAsInt();
                var sum = rawNumbers.stream().mapToInt(Integer::intValue).sum();
                minimums.add(min);
                maximums.add(max);
                totalSum+=sum;
                System.out.printf("%s:\t\t%d\t%d\t%d\n",
                        Arrays.toString(rawNumbers.toArray()),
                        min,
                        max,
                        sum);
            }
            System.out.printf("%s:\t\t%d\t%d\t%d\n", "TOTAL          ",
                    minimums.stream().mapToInt(Integer::intValue).min().getAsInt(),
                    maximums.stream().mapToInt(Integer::intValue).max().getAsInt(),
                    totalSum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task4 {
    public static void start() {
        String file1path = "./dir/saveFile1.txt";
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(7);
        numbers.add(3);
        numbers.add(2);
        numbers.add(123);
        numbers.add(-1);
        numbers.add(541);
        try {
            File dest = new File(file1path);
            dest.createNewFile();
            FileWriter fw = new FileWriter(dest);
            fw.write(Arrays.toString(numbers.toArray()) + "\n");
            fw.write(Arrays.toString(numbers.stream().mapToInt(Integer::intValue).filter(n->n%2==0).toArray()) + "\n");
            fw.write(Arrays.toString(numbers.stream().mapToInt(Integer::intValue).filter(n->n%2!=0).toArray()) + "\n");
            Collections.reverse(numbers);
            fw.write(Arrays.toString(numbers.toArray()) + "\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
//        Task1.start();
//        Task2.start();
//        Task3.start();
        Task4.start();
    }
}
