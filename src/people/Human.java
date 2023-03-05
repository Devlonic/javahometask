/**
 * People.Human
 * <p>
 * 0.0.1
 * <p>
 * Free usage (No copyright)
 */

package people;

import animals.Animal;

public abstract class Human extends Animal {
    private static int totalCreated = 0;

    public Human(int age, float weight, String name) {
        super(age, weight, name);
        totalCreated++;
    }

    private String formatSpeech(String text) {
        return String.format("%s:\t%s\n", this.name, text);
    }
    public void talk(String text) {
        System.out.print(formatSpeech(text));
    }
    public void talk(String text, Human listener) {
        this.talk("I TALK TO " + listener.getName() + ":\t\"" + text + "\"");
        listener.listen(formatSpeech(text));
    }

    public void listen(String text) {
        this.talk("I HEARD:\t" + text);
    }

    public abstract void work();
    public abstract void work(Object params);
}

