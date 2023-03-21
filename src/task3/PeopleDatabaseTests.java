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
}
