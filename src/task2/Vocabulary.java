package task2;

import java.util.*;
import java.util.stream.Collectors;

public class Vocabulary implements LanguageVocabulary {
    class Word {
        private Vocabulary vocabulary;
        private String original;
        private Set<String> translations = new HashSet<>();
        private int countRequestsToTranslations = 0;

        public Word(Vocabulary vocabulary, String original, String translation) {
            this.vocabulary = vocabulary;
            this.original = original;
            this.addTranslation(translation);
        }
        private Word(Vocabulary vocabulary, String original) {
            this.vocabulary = vocabulary;
            this.original = original;
        }

        public List<String> getTranslations() {
            countRequestsToTranslations++;
            return translations.stream().toList();
        }
        public boolean setTranslations(List<String> translations) {
            countRequestsToTranslations = 0;
            this.translations = new HashSet<>(translations);
            return true;
        }

        public boolean addTranslation(String translation) {
            return translations.add(translation);
        }
        public boolean removeTranslation(String translation) {
            return translations.remove(translation);
        }
        public boolean changeTranslation(String oldTranslation, String newTranslation) {
            return translations.remove(oldTranslation) && translations.add(newTranslation);
        }

        public int getCountRequestsToTranslations() {
            return countRequestsToTranslations;
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
        if(word == null || firstTranslation == null)
            return false;

        if(dictionary.containsKey(word))
            return false;

        var added = dictionary.put(word, new Word(this, word, firstTranslation));

        // always null
        return added == null;
    }
    private Word addWord(String word) {
        if(word == null)
            return null;

        if(dictionary.containsKey(word))
            return null;

        var wordObj = new Word(this, word);
        var added = dictionary.put(word, wordObj);

        return wordObj;
    }

    @Override
    public boolean removeWord(String word) {
        if(word == null)
            return false;

        if(!dictionary.containsKey(word))
            return false;

        return dictionary.remove(word) != null;
    }

    @Override
    public boolean changeWord(String word, String newWord) {
        if(word == null || newWord == null)
            return false;

        if(!dictionary.containsKey(word))
            return false;

        var translations = this.translate(word);

        this.removeWord(word);
        var success = this.addWord(newWord).setTranslations(translations);

        return success;
    }

    @Override
    public boolean addWordTranslation(String word, String newTranslation) {
        if(word == null || newTranslation == null)
            return false;

        if(!dictionary.containsKey(word))
            return false;

        var o = dictionary.get(word);
        return o.addTranslation(newTranslation);
    }

    @Override
    public boolean removeWordTranslation(String word, String translation) {
        if(word == null || translation == null)
            return false;

        if(!dictionary.containsKey(word))
            return false;

        var o = dictionary.get(word);

        if(o.translations.size() == 1)
            return false;

        return o.removeTranslation(translation);
    }

    @Override
    public boolean changeWordTranslation(String word, String oldTranslation, String newTranslation) {
        if(word == null || oldTranslation == null || newTranslation == null)
            return false;

        if(!dictionary.containsKey(word))
            return false;

        var o = dictionary.get(word);

        return o.changeTranslation(oldTranslation, newTranslation);
    }

    @Override
    public List<String> getTopPopularWords() {
        List<String> result = new ArrayList<>();
        var words = dictionary.values();
        var l = words.stream().
                sorted(Comparator.comparing(Word::getCountRequestsToTranslations).reversed()).
                limit(10).
                map(w-> w.original).
                collect(Collectors.toList());
        return l;
    }

    @Override
    public List<String> getTopUnPopularWords() {
        List<String> result = new ArrayList<>();
        var words = dictionary.values();
        var l = words.stream().
                sorted(Comparator.comparing(Word::getCountRequestsToTranslations)).
                limit(10).
                map(w-> w.original).
                collect(Collectors.toList());
        return l;
    }
}
