import people.Builder;
import people.Human;
import people.Pilot;
import people.Sailor;
import sales.Product;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // home task 3

        /////////////////////////////////////////////////////////////////////////
        // task1

        Human[] people = new Human[] {
            new Builder(23, 59.54f, "Ivan"),
            new Sailor(39, 92.53f, "Akakiy"),
            new Sailor(65, 42.53f, "James"),
            new Pilot(35, 72.53f, "Afanasiy"),
        };

        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            people[r.nextInt(people.length)].work();
        }

        /////////////////////////////////////////////////////////////////////////
        // task2

        /////////////////////////////////////////////////////////////////////////
        // task3
        Product p1 = new Product(642, "dollars", "cents", "Cool chocolate");
        System.out.println(p1.toString());
        p1.decreasePrice(156);
        System.out.println(p1.toString());
    }
}
