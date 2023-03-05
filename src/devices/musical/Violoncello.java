package devices.musical;

public class Violoncello extends MusicalInstrument {

    public Violoncello(String model, String description) {
        super(model, description);
    }

    @Override
    public void history() {
        System.out.println("Поява віолончелі відноситься до початку XVI століття.");
    }

    @Override
    public void sound() {
        System.out.println("*violoncello sound...*");
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
        return String.format("Violoncello %s", this.model);
    }
}
