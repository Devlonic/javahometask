import devices.*;
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

        /////////////////////////////////////////////////////////////////////////
        // task4
        Device[] devices = new Device[] {
                new Car("CoolCar2019", "WMB"),
                new Car("CoolCar2017A", "WMB"),
                new MicrowaveOven("MWO4561"),
                new Teapot("TPT2"),
                new Train("TRAIN MORRIS 2", 16.33f),
                new Car("CoolCar2023S", "WMB"),
        };

        for (var d: devices) {
            System.out.println("\n================================");
            d.show();
            d.desc();
            d.sound();
            System.out.println("================================\n");
        }
    }
}
