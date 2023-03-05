package devices;

public class Train extends Device {
    private float coalsPerHour;

    public Train(String model, float coalsPerHour) {
        super(model, "This is a device that can deliver people to different places and transport cargo");
        this.coalsPerHour = coalsPerHour;
    }

    @Override
    public void sound() {
        System.out.println("*engine noise*");
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

    @Override
    public void desc() {
        System.out.println(this.description);
    }

    @Override
    public String toString() {
        return String.format("Train %s with consumption of coal %f", this.model, this.coalsPerHour);
    }
}
