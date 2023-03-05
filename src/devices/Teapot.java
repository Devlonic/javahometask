package devices;

public class Teapot extends Device {
    public Teapot(String model) {
        super(model, "This is a device that can heat water");
    }

    @Override
    public void sound() {
        System.out.println("*whistle*");
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
        return String.format("Teapot %s", this.model);
    }
}

