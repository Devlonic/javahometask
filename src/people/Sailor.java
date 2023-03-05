package people;

public class Sailor extends Human {
    private int seaSicknessRate;

    public Sailor(int age, float weight, String name) {
        super(age, weight, name);
        this.seaSicknessRate = 0;
    }

    @Override
    public void work() {
        this.work("USS Айова");
    }

    @Override
    public void work(Object params) {
        super.talk(String.format("I serve on \"%s\" with sea sickness %d", params.toString(), this.seaSicknessRate));
        this.seaSicknessRate++;
    }
}

