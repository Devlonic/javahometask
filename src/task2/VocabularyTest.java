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
        assertArrayEquals(vocabulary.translate("Pineapple").toArray(), new Object[]{ "Ананас" });
    }

    @Test
    public void translateWord_unknown() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Pineapple", "Ананас"));
        assertEquals(vocabulary.translate("Apple"), null);
    }
}
