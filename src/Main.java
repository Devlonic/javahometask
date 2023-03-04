import collections.generic.MyList;
import infrastructure.countries.Country;
import infrastructure.settlements.CitySettleException;
import items.Book;
import items.Car;
import math.Fraction;
import people.Human;
import infrastructure.settlements.City;

public class Main {
    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////////////
        // task1
        Human h1 = new Human(19, 63.56f, "Ivan");
        Human h2 = new Human(20, 68.32f, "Vasya");
        Human h3 = new Human(25, 62.72f, "Akakiy");
        Human h4 = new Human(72, 49.23f, "Afanasiy");

        h1.talk("Hello, " + h2.getName(), h2);
        h2.talk("Hi, " + h1.getName(), h1);

        /////////////////////////////////////////////////////////////////////////
        // task2
        City c1 = new City("Kyiv", 3);
        City c2 = new City("Luts'k", 2);

        // this section shall not throw any exception
        try {
            // settle Ivan to Kyiv
            h1.changeResidence(c1);
            // settle Vasya to Kyiv
            h2.changeResidence(c1);
        } catch (CitySettleException e) {
            System.out.println("ERROR with settle to " + e.getCity().getName() + ":\t" + e.getMessage());
        }

        try {
            // throws CityHumanAlreadySettledException because h1 is already settled to c1
            h1.changeResidence(c1);
        } catch (CitySettleException e) {
            System.out.println("ERROR with settle to " + e.getCity().getName() + ":\t" + e.getMessage());
        }

        try {
            // settle Akakiy to Kyiv
            h3.changeResidence(c1);

            // throws CityOverflowException because human limit of this city is set to 3
            h4.changeResidence(c1);
        } catch (CitySettleException e) {
            System.out.println("ERROR with settle to " + e.getCity().getName() + ":\t" + e.getMessage());
        }

        try {
            // h1 is already settled in c1, so we want to change his city to c2
            h1.changeResidence(c2);
        } catch (CitySettleException e) {
            System.out.println("ERROR with settle to " + e.getCity().getName() + ":\t" + e.getMessage());
        }

        /////////////////////////////////////////////////////////////////////////
        //task3
        Country country1 = new Country("Ukraine");
        country1.addCity(c1);
        country1.addCity(c2);

        /////////////////////////////////////////////////////////////////////////
        //task4

        Fraction f1 = new Fraction(36,488);
        Fraction f2 = new Fraction(5,56);
        Fraction f3 = new Fraction(9,8,4);

        var x = Fraction.add(f1, f2);
        System.out.println(x.toString());

        var y = Fraction.add(x, 100);
        System.out.println(y.toString());

        /////////////////////////////////////////////////////////////////////////
        //task5
        Book b = new Book();
        b.print(System.out);

        /////////////////////////////////////////////////////////////////////////
        //task6
        Car c = new Car();
        c.print(System.out);
    }
}
