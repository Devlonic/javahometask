package devices;

public abstract class Device {
    public Device(String model, String description) {
        this.model = model;
        this.description = description;
    }

    protected String model;
    protected String description;

    public abstract void sound();
    public abstract void show();
    public abstract void desc();
}

