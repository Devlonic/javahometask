package devices.musical;

public class Trombone extends MusicalInstrument {

    public Trombone(String model, String description) {
        super(model, description);
    }

    @Override
    public void history() {
        System.out.println("Поява тромбона відноситься до XV століття. Прийнято вважати, що безпосередніми попередниками цього інструменту були кулісні труби, при грі на яких музикант мав можливість пересувати трубку інструменту, таким чином отримуючи хроматичний звукоряд.");
    }

    @Override
    public void sound() {
        System.out.println("*trombone sound...*");
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
        return String.format("Trombone %s", this.model);
    }
}


