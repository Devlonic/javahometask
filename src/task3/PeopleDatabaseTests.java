package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleDatabaseTests {
    @Test
    public void addPerson_normal() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan", "city");

        assertTrue(pd.addPerson(person));
    }

    @Test
    public void addPerson_printPerson_normal() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan", "city");

        assertTrue(pd.addPerson(person));
        assertEquals(String.format("Person{id='%s', name='Ivan', fines=[]}", person.getId()), pd.printPerson(person.getId()));
    }

    @Test
    public void addPerson_alreadyInDatabase() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan", "city");

        assertTrue(pd.addPerson(person));
        assertFalse(pd.addPerson(person));
    }

    @Test
    public void addFine_normal() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan", "city");

        assertTrue(pd.addPerson(person));
        assertTrue(pd.addFine(person.getId(), "Speed over limit"));
        assertTrue(pd.addFine(person.getId(), "Speed over limit"));
        assertTrue(pd.addFine(person.getId(), "Smoking in the wrong place"));
        assertEquals("Person{id='1', name='Ivan', fines=[Speed over limit, Speed over limit, Smoking in the wrong place]}", pd.printPerson(person.getId()));
    }

    @Test
    public void addFine_notFound() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan", "city");

        assertTrue(pd.addPerson(person));
        assertFalse(pd.addFine(person.getId()+"w", "Speed over limit"));
    }

    @Test
    public void all_nullsCheck() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan", "city");

        assertFalse(pd.addPerson(null));
        assertTrue(pd.addPerson(person));
        assertEquals("Wrong id", pd.printPerson(null));
        assertFalse(pd.addFine(person.getId(), null));
        assertFalse(pd.addFine(null, "Speed over limit"));
        assertFalse(pd.addFine(null, null));
    }

    @Test
    public void getAllByFine_normal() {
        PeopleDatabase pd = new PeopleDatabase();

        Person[] people = new Person[] {
                new Person("Vasya", "city"),
                new Person("John", "city"),
                new Person("Mike", "city"),
                new Person("Ivan", "city"),
        };

        for (var person :
                people) {
            assertTrue(pd.addPerson(person));
        }

        String[] fines = new String[] {
                "Speed over limit",
                "Smoking in the wrong place",
                "Driving under alcohol"
        };

        pd.addFine(people[0].getId(), fines[0]);
        pd.addFine(people[0].getId(), fines[1]);

        pd.addFine(people[1].getId(), fines[1]);

        pd.addFine(people[2].getId(), fines[1]);
        pd.addFine(people[2].getId(), fines[2]);
        pd.addFine(people[2].getId(), fines[1]);
        pd.addFine(people[2].getId(), fines[1]);

        var x = pd.getAllByFine(fines[1]);
        assertEquals(78, x.length());
    }

    @Test
    public void getAllByCity_normal() {
        PeopleDatabase pd = new PeopleDatabase();

        Person[] people = new Person[] {
                new Person("Vasya", "city"),
                new Person("John", "city"),
                new Person("Mike", "city2"),
                new Person("Ivan", "city"),
        };

        String[] fines = new String[] {
                "Speed over limit",
                "Smoking in the wrong place",
                "Driving under alcohol"
        };

        for (var person :
                people) {
            assertTrue(pd.addPerson(person));
        }

        assertTrue(pd.addFine(people[0].getId(), fines[0]));
        pd.addFine(people[0].getId(), fines[1]);

        pd.addFine(people[1].getId(), fines[1]);

        pd.addFine(people[2].getId(), fines[1]);
        pd.addFine(people[2].getId(), fines[2]);
        pd.addFine(people[2].getId(), fines[1]);
        pd.addFine(people[2].getId(), fines[1]);



        System.out.println(pd.getAllByCity("city"));

        assertEquals(178, pd.getAllByCity("city").length());
    }
}
