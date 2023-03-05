package devices.musical;

public class Ukulele extends MusicalInstrument {

    public Ukulele(String model, String description) {
        super(model, description);
    }

    @Override
    public void history() {
        System.out.println("Перші прообрази укулеле з'явилися у Європі, у середині 15 століття. У ті роки було добре розвинене виробництво струнних інструментів, але більш складні гітари і мандоліни, були досить коштовними, особливо для бродячих музик. Попит народжує пропозицію, і на ринку почали з'являтися зменшені гітари з усього чотирма струнами — кавакіньо, які стали прообразом укулеле.");
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
        return String.format("Ukulele %s", this.model);
    }
}

