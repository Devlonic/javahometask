package task3;

import java.util.*;

public class PeopleDatabase {
    private HashMap<String, Person> people = new HashMap<>();

    public boolean addPerson(Person person) {
        if(people.containsKey(person.getId()))
            return false;

        return this.people.put(person.getId(), person) == null;
    }

    public String printPerson(String id) {
        if(!people.containsKey(id))
            return "Not found";

        return people.get(id).toString();
    }
}
