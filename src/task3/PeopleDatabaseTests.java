package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleDatabaseTests {
    @Test
    public void addPerson_normal() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan");

        assertTrue(pd.addPerson(person));
    }

    @Test
    public void addPerson_printPerson_normal() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan");

        assertTrue(pd.addPerson(person));
        assertEquals(String.format("Person{id='%s', name='Ivan', fines=[]}", person.getId()), pd.printPerson(person.getId()));
    }

    @Test
    public void addPerson_alreadyInDatabase() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan");

        assertTrue(pd.addPerson(person));
        assertFalse(pd.addPerson(person));
    }

    @Test
    public void addFine_normal() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan");

        assertTrue(pd.addPerson(person));
        assertTrue(pd.addFine(person.getId(), "Speed over limit"));
        assertTrue(pd.addFine(person.getId(), "Speed over limit"));
        assertTrue(pd.addFine(person.getId(), "Smoking in the wrong place"));
        assertEquals("Person{id='1', name='Ivan', fines=[Speed over limit, Speed over limit, Smoking in the wrong place]}", pd.printPerson(person.getId()));
    }

    @Test
    public void addFine_notFound() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan");

        assertTrue(pd.addPerson(person));
        assertFalse(pd.addFine(person.getId()+"w", "Speed over limit"));
    }

    @Test
    public void all_nullsCheck() {
        PeopleDatabase pd = new PeopleDatabase();

        Person person = new Person("Ivan");

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
                new Person("Vasya"),
                new Person("John"),
                new Person("Mike"),
                new Person("Ivan"),
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

        assertEquals(String.format("Person ID: %s, Name: Vasya\n" +
                "Person ID: %s, Name: John\n" +
                "Person ID: %s, Name: Mike", people[0].getId(), people[1].getId(), people[2].getId()), pd.getAllByFine(fines[1]));
    }
}
