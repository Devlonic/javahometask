package animals;

public class Kangaroo extends Animal {
    private static int countEntities = 0;

    public Kangaroo(float weight) {
        super(0, weight, String.format("Tiger %d", ++countEntities));
    }
}
