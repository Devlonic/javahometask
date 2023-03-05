package animals;

public class Tiger extends Animal {
    private static int countEntities = 0;
    public Tiger(float weight) {
        super(0, weight, String.format( "Tiger %d", ++countEntities));
    }
}

