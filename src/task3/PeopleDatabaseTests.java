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
        assertEquals("Person{id='0', name='Ivan', fines=[]}", pd.printPerson("0"));
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
        assertEquals("Person{id='0', name='Ivan', fines=[Speed over limit, Speed over limit, Smoking in the wrong place]}", pd.printPerson(person.getId()));
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
}
