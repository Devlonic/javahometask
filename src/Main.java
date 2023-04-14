import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
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

public class Main {
    public static void main(String[] args) {
        Task1.start();
    }
}
