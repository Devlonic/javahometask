import people.Builder;
import people.Human;

public class Main {
    public static void main(String[] args) {
        // home task 3

        /////////////////////////////////////////////////////////////////////////
        // task1

        Human h1 = new Builder(23, 59.54f, "Ivan");
        h1.work();
        h1.work("Cool house");
        h1.work("Big house");
    }
}
