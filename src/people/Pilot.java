package people;

public class Pilot extends Human {
    private int flySkill;

    public Pilot(int age, float weight, String name) {

        super(age, weight, name);
        this.flySkill = 0;
    }

    @Override
    public void work() {
        this.work("Boeing 777");
    }

    @Override
    public void work(Object params) {
        super.talk(String.format("I fly on \"%s\" with skill %d", params.toString(), this.flySkill));
        this.flySkill++;
    }
}
