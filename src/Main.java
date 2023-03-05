import devices.*;
import devices.musical.*;
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

        /////////////////////////////////////////////////////////////////////////
        // task5
        MusicalInstrument[] instruments = new MusicalInstrument[] {
                new Trombone("OTB1500", "Сі-бемоль (Bb)"),
                new Ukulele("DU-101 Rainbow Soprano Ukulele Brown", "Diamond Head - это укулеле, которые доступны в тринадцати привлекательных цветов на выбор, они понравятся детям и взрослым! Нет лучшего способа познакомить ребенка с музыкальными радостями, чем купить яркое и легко играющее укулеле Diamond Head. Качество и обработка первоклассные, а тон мягкий и приятный. Колки в гитарном стиле облегчают настройку для новичков. Каждый инструмент поставляется с прочным чехлом."),
                new Violin("Yamaha V3SKA 1/2", """
                        Розмір інструменту 3/4
                        Особливості Ручна робота
                        Колір Violinburst"""),
                new Violoncello("Saga SC-100", "Віолончель Cremona Premier: Novice Cello, топ-цільна ялина, задня дека і боки-цільний клен, накладка-палісандр, смичок-бразильське дерево кінський волос, коричневий"),
        };

        for (var i: instruments) {
            System.out.println("\n================================");
            i.show();
            i.desc();
            i.history();
            i.sound();
            System.out.println("================================\n");
        }
    }
}
