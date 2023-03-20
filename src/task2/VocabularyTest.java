package task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class VocabularyTest {
    @Test
    public void addWord_null() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertFalse(vocabulary.addWord(null, null));
        assertFalse(vocabulary.addWord("Apple", null));
        assertFalse(vocabulary.addWord(null, "Груша"));
    }

    @Test
    public void addWord_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Pineapple", "Ананас"));
    }

    @Test
    public void addWord_alreadyExist() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Pineapple", "Ананас"));
        assertFalse(vocabulary.addWord("Pineapple", "Ананас123"));
    }

    @Test
    public void translateWord_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Pineapple", "Ананас"));
        assertArrayEquals(new Object[]{ "Ананас" }, vocabulary.translate("Pineapple").toArray());
    }

    @Test
    public void translateWord_unknown() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Pineapple", "Ананас"));
        assertEquals( null, vocabulary.translate("Apple"));
    }

    @Test
    public void removeWord_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Pineapple", "Ананас"));
        assertArrayEquals(vocabulary.translate("Pineapple").toArray(), new Object[]{ "Ананас" });
        assertTrue(vocabulary.removeWord("Pineapple"));
        assertEquals( null, vocabulary.translate("Pineapple"));
    }

    @Test
    public void changeWord_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Pieapple", "Ананас"));
        assertTrue(vocabulary.changeWord("Pieapple", "Pineapple"));

        assertArrayEquals( new Object[]{ "Ананас" }, vocabulary.translate("Pineapple").toArray());
    }

    @Test
    public void changeWord_nulls() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertFalse(vocabulary.addWord(null, null));
        assertFalse(vocabulary.changeWord(null, "Hello"));
    }

    @Test
    public void changeWord_notExists() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertFalse(vocabulary.changeWord("Pieapple", "Pineapple"));
    }
}
