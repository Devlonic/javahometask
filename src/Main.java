import java.io.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Task1 {
    public static void start() {
        int[] arr = new int[10];

        Thread t1 = new Thread(()->{
            System.out.println("t1 start");
            System.out.println("t1 begin");
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                arr[i] = r.nextInt(10);
            }
            System.out.println("filled " + Arrays.toString(arr));
        });

        Thread t2 = new Thread(()->{
            System.out.println("t2 start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2 begin");

            int sum = 0;
            for (var num: arr) {
                sum += num;
            }
            System.out.println("sum is " + sum);
        });
        Thread t3 = new Thread(()->{
            System.out.println("t3 start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t3 begin");

            int avg = 0;
            for (var num: arr) {
                avg += num;
            }
            System.out.println("avg is " + avg / arr.length);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

class Task2 {
    public static void start() {
        int[] arr = new int[10];

        String filename;
        System.out.println("Enter filename: ");
        Scanner cin = new Scanner(System.in);
        var n = cin.nextLine();
        filename = "./files/" + n + ".txt";
        var resultFilename = "./files/" + n + "_result" + ".txt";

        Thread t1 = new Thread(()->{
            System.out.println("t1 start");
            System.out.println("t1 begin");
            Random r = new Random();
            try(FileWriter fw = new FileWriter(filename, false)) {
                for (int i = 0; i < 10; i++) {
                    int rn = r.nextInt(10);
                    fw.write(Integer.toString(rn) + " ");
                    System.out.println(rn);
                }
                fw.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("t2 start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2 begin");

            List<Byte> simpleNumbers = new ArrayList<>();

            try(Scanner s = new Scanner(new File(filename))) {
                do {
                    byte b = s.nextByte();

                    boolean isSimple = true;
                    for (int i = 2; i < b; i++) {
                        if(b % i == 0) {
                            isSimple = false;
                            break;
                        }
                    }
                    if(b >= 1 && isSimple)
                        simpleNumbers.add(b);
                } while (s.hasNextByte());
                var res = Arrays.toString(simpleNumbers.toArray());
                synchronized (resultFilename) {
                    FileWriter fw = new FileWriter(resultFilename, true);
                    fw.write("Simple numbers: " + res + "\n");
                    fw.flush();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        });

        Thread t3 = new Thread(()->{
            System.out.println("t3 start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t3 begin");

            List<Long> factorials = new ArrayList<>();

            try(Scanner s = new Scanner(new File(filename))) {
                do {
                    byte b = s.nextByte();
                    long fact = 1;
                    for (int i = 1; i <= b; i++) {
                        fact *= i;
                    }
                    factorials.add(fact);
                } while (s.hasNextByte());
                var res = Arrays.toString(factorials.toArray());
                synchronized (resultFilename) {
                    FileWriter fw = new FileWriter(resultFilename, true);
                    fw.write("Factorials: " + res + "\n");
                    fw.flush();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        });


        t1.start();
        t2.start();
        t3.start();
    }
}

class Task3 {
    public static void start() {
        int[] arr = new int[10];

        String oldDirectory;
        String newDirectory;
        var s = new Scanner(System.in);
        System.out.println("Enter old directory: ");
        oldDirectory = s.nextLine();
        System.out.println("Enter new directory: ");
        newDirectory = s.nextLine();

        Thread t = new DirectoryCopyrator(oldDirectory, newDirectory);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    static class DirectoryCopyrator extends Thread {
        String sourceFolderPath ;
        String destinationFolderPath ;

        public DirectoryCopyrator(String sourceFolderPath, String destinationFolderPath  ) {
            this.sourceFolderPath = sourceFolderPath;
            this.destinationFolderPath = destinationFolderPath  ;
        }

        @Override
        public void run() {
            try {
                copyDirectory();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void copyDirectory() throws IOException {
            Path sourcePath = Paths.get(sourceFolderPath);
            Path destinationPath = Paths.get(destinationFolderPath);
            Files.walk(sourcePath)
                    .forEach(source -> {
                        try {
                            Path destination = destinationPath.resolve(sourcePath.relativize(source));
                            if (Files.isDirectory(source)) {
                                Files.createDirectories(destination);
                            } else {
                                Files.copy(source, destination);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println("Copied!");
        }
    }

}


public class Main {
    public static void main(String[] args) throws IOException {
        //Task1.start();
        //Task2.start();
        Task3.start();
    }
}
