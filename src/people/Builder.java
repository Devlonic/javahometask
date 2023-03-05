package people;

public class Builder extends Human {
    private int buildingSkill;

    public Builder(int age, float weight, String name) {

        super(age, weight, name);
        this.buildingSkill = 0;
    }

    @Override
    public void work() {
        this.work("Example house");
    }

    @Override
    public void work(Object params) {
        super.talk(String.format("I building on \"%s\" with skill %d", params.toString(), this.buildingSkill));
        this.buildingSkill++;
    }
}
