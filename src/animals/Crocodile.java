package animals;

public class Crocodile extends Animal {
    private static int countEntities = 0;

    public Crocodile(float weight) {
        super(0, weight, String.format("Crocodile %d", ++countEntities));
    }
}
