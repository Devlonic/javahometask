package task3;

import java.util.*;
import java.util.stream.Collectors;

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

    public String getAllByFine(String fine) {
        return people.values().stream().filter(p->p.getFines().contains(fine)).map(p-> {
            return String.format("Person ID: %s, Name: %s", p.getId(), p.getName());
        }).collect(Collectors.joining("\n"));
    }

    public String getAllByCity(String city) {
        return people.values().stream().filter(p-> Objects.equals(p.getCity(), city)).map(p-> {
            return String.format("Person ID: %s, Name: %s, Fines: %s", p.getId(), p.getName(), p.getFines());
        }).collect(Collectors.joining("\n"));
    }

    public boolean removeFine(String personId, String fine) {
        if(personId == null || fine == null)
            return false;

        if(!people.containsKey(personId))
            return false;

        return people.get(personId).removeFine(fine);
    }
}
