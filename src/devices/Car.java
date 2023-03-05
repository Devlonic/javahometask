package devices;

public class Car extends Device {
    private String manufacturer;

    public Car(String model, String manufacturer) {
        super(model, "This is a device that can deliver from one place to another");
        this.manufacturer = manufacturer;
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
        return String.format("Car %s by %s", this.model, this.manufacturer);
    }
}

