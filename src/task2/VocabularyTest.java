package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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


    @Test
    public void addTranslation_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Main", "Основний"));
        assertArrayEquals(new Object[]{ "Основний" }, vocabulary.translate("Main").toArray());
        assertTrue(vocabulary.addWordTranslation("Main", "Головний"));
        assertArrayEquals(new Object[]{ "Основний", "Головний" }, vocabulary.translate("Main").toArray());
    }
    @Test
    public void addTranslation_alreadyExist() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Main", "Основний"));
        assertArrayEquals(new Object[]{ "Основний" }, vocabulary.translate("Main").toArray());
        assertTrue(vocabulary.addWordTranslation("Main", "Головний"));
        assertArrayEquals(new Object[]{ "Основний", "Головний" }, vocabulary.translate("Main").toArray());
        assertFalse(vocabulary.addWordTranslation("Main", "Головний"));
        assertArrayEquals(new Object[]{ "Основний", "Головний" }, vocabulary.translate("Main").toArray());
    }

    @Test
    public void addTranslation_nulls() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Main", "Основний"));
        assertArrayEquals(new Object[]{ "Основний" }, vocabulary.translate("Main").toArray());
        assertFalse(vocabulary.addWordTranslation("Main", null));
        assertArrayEquals(new Object[]{ "Основний" }, vocabulary.translate("Main").toArray());
    }

    @Test
    public void removeTranslation_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Main", "qОсновний"));
        assertTrue(vocabulary.addWordTranslation("Main", "Головний"));
        assertArrayEquals(new Object[]{ "Головний", "qОсновний" }, vocabulary.translate("Main").toArray());

        assertTrue(vocabulary.removeWordTranslation("Main", "qОсновний"));
        assertArrayEquals(new Object[]{"Головний"}, vocabulary.translate("Main").toArray());
    }

    @Test
    public void removeTranslation_lastTranslationInWord() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Main", "qОсновний"));
        assertArrayEquals(new Object[]{ "qОсновний" }, vocabulary.translate("Main").toArray());

        assertFalse(vocabulary.removeWordTranslation("Main", "qОсновний"));
        assertArrayEquals(new Object[]{"qОсновний"}, vocabulary.translate("Main").toArray());
    }

    @Test
    public void removeTranslation_nulls() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Main", "qОсновний"));
        assertArrayEquals(new Object[]{ "qОсновний" }, vocabulary.translate("Main").toArray());

        assertFalse(vocabulary.removeWordTranslation("Main", null));
        assertArrayEquals(new Object[]{"qОсновний"}, vocabulary.translate("Main").toArray());
    }

    @Test
    public void changeTranslation_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Main", "qОсновний"));
        assertTrue(vocabulary.addWordTranslation("Main", "Головний"));
        assertArrayEquals(new Object[]{ "Головний", "qОсновний" }, vocabulary.translate("Main").toArray());

        assertTrue(vocabulary.changeWordTranslation("Main", "qОсновний", "Основний"));
        assertArrayEquals(new Object[]{"Головний", "Основний" }, vocabulary.translate("Main").toArray());
    }

    @Test
    public void changeTranslation_nulls() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        assertTrue(vocabulary.addWord("Main", "qОсновний"));
        assertTrue(vocabulary.addWordTranslation("Main", "Головний"));
        assertArrayEquals(new Object[]{ "Головний", "qОсновний" }, vocabulary.translate("Main").toArray());

        assertFalse(vocabulary.changeWordTranslation("Main", "qОсновний", null));
        assertArrayEquals(new Object[]{"Головний", "qОсновний" }, vocabulary.translate("Main").toArray());
    }

    static Random r = new Random();
    private String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char)(r.nextInt('z' - 'a') + 'a'));
        }
        return sb.toString();
    }

    @Test
    public void getTopPopularWords_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        List<String> existingWords = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            var word = getRandomString(12);
            existingWords.add(word);
            vocabulary.addWord(word, getRandomString(12));
            for (int j = 0; j < 4; j++) {
                vocabulary.addWordTranslation(word, getRandomString(12));
            }
        }

        for (int i = 99; i >= 0; i--) {
            var word = existingWords.get(i);
            for (int j = 0; j < i; j++) {
                vocabulary.translate(word);
            }
        }

        var firstWords = existingWords.subList(90, 100);
        Collections.reverse(firstWords);

        assertArrayEquals(firstWords.toArray(), vocabulary.getTopPopularWords().toArray());
    }

    @Test
    public void getTopUnPopularWords_normal() {
        Vocabulary vocabulary = new Vocabulary("English", "Українська");

        List<String> existingWords = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            var word = getRandomString(12);
            existingWords.add(word);
            vocabulary.addWord(word, getRandomString(12));
            for (int j = 0; j < 4; j++) {
                vocabulary.addWordTranslation(word, getRandomString(12));
            }
        }

        for (int i = 99; i >= 0; i--) {
            var word = existingWords.get(i);
            for (int j = 0; j < i; j++) {
                vocabulary.translate(word);
            }
        }

        var firstWords = existingWords.subList(0, 10);

        assertArrayEquals(firstWords.toArray(), vocabulary.getTopUnPopularWords().toArray());
    }
}
