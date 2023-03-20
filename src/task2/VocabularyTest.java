package task2;


import org.junit.Test;

import static org.junit.Assert.assertFalse;

class VocabularyTest {
    @Test
    void translate() {
    }

    @Test
    void addWord_testNull() {
        LanguageVocabulary vocabulary = new Vocabulary("English", "Ukrainian");

        assertFalse(vocabulary.addWord(null, null));
        assertFalse(vocabulary.addWord("Apple", null));
        assertFalse(vocabulary.addWord(null, "Груша"));
    }

    @Test
    void removeWord() {
    }

    @Test
    void changeWord() {
    }

    @Test
    void addWordTranslation() {
    }

    @Test
    void removeWordTranslation() {
    }

    @Test
    void changeWordTranslation() {
    }

    @Test
    void getTopPopularWords() {
    }

    @Test
    void getTopUnPopularWords() {
    }
}