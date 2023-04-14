import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.function.Predicate;
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

class Task5 {
    public static void start() {
        Corporation c = new Corporation();
        c.menu();
    }

    static class Corporation {
        private String databaseFile;
        private List<Employee> employees = new ArrayList<>();

        public Corporation() {
            this.databaseFile = "./dir/corporation.txt";
            load();
//            this.employees.add(new Employee("Ivan", "Smith", 23));
//            this.employees.add(new Employee("Jane", "Kmith", 22));
//            this.employees.add(new Employee("Jan", "Skads", 66));
//            this.employees.add(new Employee("Kan", "Sannoff", 999));
//            this.employees.add(new Employee("Van", "Hoenheim", 999));
        }

        public void menu() {
            Scanner ui = new Scanner(System.in);
            while (true) {
                System.out.println("0\tExit");
                System.out.println("1\tPrint all to console");
                System.out.println("2\tSave all to file");
                System.out.println("3\tLoad all from file");
                System.out.println("4\tPrint by surname");
                System.out.println("5\tPrint by age");
                System.out.println("6\tPrint by first surname letter");
                System.out.println("7\tDelete by surname");

                switch (ui.nextInt()) {
                    case 0:
                        return;
                    case 1: print(e->true, System.out); break;
                    case 2: save(); break;
                    case 3: load(); break;
                    case 4: {
                        System.out.print("Enter surname: ");
                        var flush = ui.nextLine();
                        printBySurname(ui.nextLine(), System.out);
                        break;
                    }
                    case 5: {
                        System.out.print("Enter age: ");
//                        var flush = ui.nextInt();
                        printByAge(ui.nextInt(), System.out);
                        break;
                    }
                    case 6: {
                        System.out.print("Enter letter: ");
                        ui.nextLine();
                        printByFirstLetter(ui.nextLine().charAt(0), System.out);
                        break;
                    }
                    case 7: {
                        System.out.print("Enter surname: ");
                        var flush = ui.nextLine();
                        deleteBySurname(ui.nextLine(), System.out);
                        break;
                    }
                    default: break;
                }
                System.out.println("Press enter to continue");
                ui.nextLine();
                ui.nextLine();
                // clear console
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
            }
        }

        private void save() {
            try(FileOutputStream fos = new FileOutputStream(this.databaseFile)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(employees);
                oos.close();
                fos.close();
                System.out.println("saved " + employees.stream().count() + " employees");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void load() {
            try (FileInputStream fis = new FileInputStream(this.databaseFile)) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                this.employees = (ArrayList<Employee>)ois.readObject();
                System.out.println("loaded " + this.employees.stream().count() + " employees");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private Stream<Employee> getByPredicate(Predicate<Employee> predicate) {
            return employees.stream().filter(predicate);
        }

        private void print(Predicate<Employee> predicate, PrintStream ps) {
            getByPredicate(predicate).forEach(e->{
                ps.println(e.toString());
            });
        }

        private Employee getBySurname(String surname) {
            var arr = getByPredicate(e->e.surname.equals(surname)).toArray();
            if(arr.length == 0)
                return null;
            else
                return (Employee)arr[0];
        }
        private Employee[] getByAge(int age) {
            var arr = getByPredicate(e->e.age == age).toArray(Employee[]::new);
            if(arr.length == 0)
                return null;
            else
                return arr;
        }
        private Employee[] getByFirstLetter(char letter) {
            var arr = getByPredicate(e->e.surname.toLowerCase().startsWith(Character.toString(letter).toLowerCase()) ).toArray(Employee[]::new);
            if(arr.length == 0)
                return null;
            else
                return arr;
        }
        private void printBySurname(String surname, PrintStream ps) {
            var e = getBySurname(surname);
            if(e == null)
                ps.println("not found");
            else
                ps.println(e.toString());
        }
        private void deleteBySurname(String surname, PrintStream ps) {
            var e = getBySurname(surname);
            if(e == null)
                ps.println("not found");
            else {
                employees.remove(e);
                ps.println(e.toString() + " was removed");
            }
        }
        private void printByAge(int age, PrintStream ps) {
            var e = getByAge(age);
            if(e == null)
                ps.println("not found");
            else
                Arrays.stream(e).forEach(em->{
                    ps.println(em.toString());
                });
        }
        private void printByFirstLetter(char l, PrintStream ps) {
            var e = getByFirstLetter(l);
            if(e == null)
                ps.println("not found");
            else
                Arrays.stream(e).forEach(em->{
                    ps.println(em.toString());
                });
        }
    }
    static class Employee implements Serializable {
        private String name;
        private String surname;
        private int age;

        public Employee(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

public class Main {
    public static void main(String[] args) {
//        Task1.start();
//        Task2.start();
//        Task3.start();
//        Task4.start();
        Task5.start();
    }
}
