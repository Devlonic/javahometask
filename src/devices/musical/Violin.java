package devices.musical;

public class Violin extends MusicalInstrument {

    public Violin(String model, String description) {
        super(model, description);
    }

    @Override
    public void history() {
        System.out.println("Прототипами скрипки були арабський ребаб і німецька рота, злиття яких і утворило віолу. Форми скрипки сформувались до XVI століття;");
    }

    @Override
    public void sound() {
        System.out.println("*violin sound...*");
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
        return String.format("Violin %s", this.model);
    }
}

