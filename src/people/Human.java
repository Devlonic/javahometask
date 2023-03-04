/**
 * People.Human
 * <p>
 * 0.0.1
 * <p>
 * Free usage (No copyright)
 */

package people;

import infrastructure.settlements.City;

public class Human {
    private static int totalCreated = 0;

    protected String name;
    private int age;
    private float weight;
    private City residence;

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    private Human() {
        Human.totalCreated++;
    }
    public Human(int age, float weight, String name) {
        this();

        this.throwOnValidationFault(age, weight, name);

        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    private boolean isAgeWrong(int age) {
        return age < 0;
    }
    private boolean isWeightWrong(float weight) {
        return weight <= 0;
    }
    private boolean isNameWrong(String name) {
        return name == null || name.isBlank();
    }
    private void throwOnValidationFault(int age, float weight, String name) {
        if(isAgeWrong(age))
            throw new IllegalArgumentException("age is wrong");
        if(isWeightWrong(weight))
            throw new IllegalArgumentException("weight is wrong");
        if(isNameWrong(name))
            throw new IllegalArgumentException("name is wrong");
    }

    private String formatSpeech(String text) {
        return String.format("%s:\t%s\n", this.name, text);
    }
    public void talk(String text) {
        System.out.print(formatSpeech(text));
    }
    public void talk(String text, Human listener) {
        this.talk("I TALK TO " + listener.getName() + ":\t\"" + text + "\"");
        listener.listen(formatSpeech(text));
    }

    public void listen(String text) {
        this.talk("I HEARD:\t" + text);
    }

    public void changeResidence(City newResidence) {
        // if human is already settled - evict it from city
        if(this.residence != newResidence && this.residence != null) {
            this.residence.evict(this);
        }

        newResidence.settle(this);
        this.residence = newResidence;
    }
}
