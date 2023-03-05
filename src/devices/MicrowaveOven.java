package devices;

public class MicrowaveOven extends Device {
    public MicrowaveOven(String model) {
        super(model, "This is a device that can heat food");
    }

    @Override
    public void sound() {
        System.out.println("*buzz*... *beep-beep-beep*");
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
        return String.format("Microwave %s", this.model);
    }
}

