package task3;

import java.util.*;

public class PeopleDatabase {
    private HashMap<String, Person> people = new HashMap<>();

    public boolean addPerson(Person person) {
        if(person == null)
            return false;

        if(people.containsKey(person.getId()))
            return false;

        return this.people.put(person.getId(), person) == null;
    }

    public String printPerson(String id) {
        if(id == null)
            return "Wrong id";

        if(!people.containsKey(id))
            return "Not found";

        return people.get(id).toString();
    }

    public boolean addFine(String personId, String fine) {
        if(personId == null || fine == null)
            return false;

        if(!people.containsKey(personId))
            return false;

        return people.get(personId).addFine(fine);
    }
}
