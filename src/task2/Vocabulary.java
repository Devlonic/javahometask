package task2;

import java.util.*;

public class Vocabulary implements LanguageVocabulary {
    class Word {
        private Vocabulary vocabulary;
        private String original;
        private Set<String> translations = new HashSet<>();

        public Word(Vocabulary vocabulary, String original, String translation) {
            this.vocabulary = vocabulary;
            this.original = original;
            this.addTranslation(translation);
        }

        public List<String> getTranslations() {
            return translations.stream().toList();
        }

        public boolean addTranslation(String translation) {
            return translations.add(translation);
        }
    }

    private String originalLanguage;
    private String translateLanguage;
    private LinkedHashMap<String, Word> dictionary = new LinkedHashMap<>();

    public Vocabulary(String originalLanguage, String translateLanguage) {
        this.originalLanguage = originalLanguage;
        this.translateLanguage = translateLanguage;
    }

    @Override
    public List<String> translate(String originalWord) {
        if(dictionary.containsKey(originalWord))
            return dictionary.get(originalWord).getTranslations();

        return null;
    }

    @Override
    public boolean addWord(String word, String firstTranslation) {
        if(dictionary.containsKey(word))
            return false;

        var added = dictionary.put(word, new Word(this, word, firstTranslation));

        // always null
        return added == null;
    }

    @Override
    public boolean removeWord(String word) {
        return false;
    }

    @Override
    public boolean changeWord(String word, String newWord) {
        return false;
    }

    @Override
    public boolean addWordTranslation(String word, String newTranslation) {
        return false;
    }

    @Override
    public boolean removeWordTranslation(String word, String translation) {
        return false;
    }

    @Override
    public boolean changeWordTranslation(String word, String oldTranslation, String newTranslation) {
        return false;
    }

    @Override
    public List<String> getTopPopularWords() {
        return null;
    }

    @Override
    public List<String> getTopUnPopularWords() {
        return null;
    }
}
