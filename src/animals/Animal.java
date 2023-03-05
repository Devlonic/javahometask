package animals;

public abstract class Animal {
    protected String name;
    private int age;
    private float weight;

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public Animal(int age, float weight, String name) {

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
}

