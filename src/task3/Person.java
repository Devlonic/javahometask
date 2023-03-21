package task3;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private static int countCreated = 0;

    private String id;
    private String name;
    private List<String> fines = new LinkedList<>();

    private String getNewId() {
        return String.valueOf(countCreated++);
    }

    public Person(String name) {
        this.id = getNewId();
        this.name = name;
    }

    public boolean addFine(String fine) {
        return fines.add(fine);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getFines() {
        return fines.stream().toList();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fines=" + fines +
                '}';
    }
}
