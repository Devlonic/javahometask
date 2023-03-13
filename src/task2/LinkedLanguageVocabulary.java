package task2;

import java.util.*;

public class LinkedLanguageVocabulary implements LanguageVocabulary {
    class LanguageVocabularyWord {
        private String origin;
        private HashSet<String> translations;
        private LanguageVocabulary vocabulary;

        private int usageFrequency = 0;

        public LanguageVocabularyWord(String origin, List<String> translations, LanguageVocabulary vocabulary) {
            this.origin = origin;
            this.translations = new HashSet<>(translations);
            this.vocabulary = vocabulary;
        }
        public LanguageVocabularyWord(String word, LanguageVocabulary vocabulary, String... translations) {
            this(word, List.of(translations), vocabulary);
        }
        public LanguageVocabularyWord(String word, LanguageVocabulary vocabulary) {
            this(word, List.of(), vocabulary);
        }

        public List<String> getTranslations() {
            this.usageFrequency++;
            return new ArrayList<>(this.translations);
        }
        public String getOrigin() {
            return origin;
        }
        public int getUsageFrequency() {
            return usageFrequency;
        }

        public void addTranslation(String translation) {
            if(this.translations.add(translation) == false)
                throw new TranslationAlreadyExistVocabularyException(translation, this, this.vocabulary);
        }
        public void replaceTranslation(String oldTranslation, String newTranslation) {
            if(!this.translations.contains(oldTranslation))
                throw new TranslationNotExistVocabularyException(oldTranslation, this, this.vocabulary);

            this.translations.remove(oldTranslation);
            this.translations.add(newTranslation);
        }
        public void removeTranslation(String translation) {
            if(!this.translations.contains(translation))
                throw new TranslationNotExistVocabularyException(translation, this, this.vocabulary);

            this.translations.remove(translation);
        }
    }

    private String originLanguage;
    private String translateLanguage;
    private Map<String, LanguageVocabularyWord> words = new LinkedHashMap<>();

    public LinkedLanguageVocabulary(String originLanguage, String translateLanguage) {
        this.originLanguage = originLanguage;
        this.translateLanguage = translateLanguage;
    }
    public LinkedLanguageVocabulary() {
        this.originLanguage = "English";
        this.translateLanguage = "Українська";
        this.init();
    }

    private void init() {
        this.addWord(new LanguageVocabularyWord("board", this, "дошка", "стіл", "плата"));
    }

    @Override
    public List<String> translate(String originWord) {
        var word = this.words.get(originWord);

        if(word == null)
            throw new WordNotExistVocabularyException(originWord, this);

        return word.getTranslations();
    }

    @Override
    public void display(String originWord) {
        System.out.printf("\'%s - %s\' \'%s = %s\'\n", this.originLanguage, this.translateLanguage, originWord, this.translate(originWord));
    }

    @Override
    public void addWord(String originWord, List<String> translations) {
        this.addWord(new LanguageVocabularyWord(originWord, translations, this));
    }

    private void addWord(LanguageVocabularyWord word) {
        if(this.words.put(word.origin, word) != null)
            throw new WordAlreadyExistVocabularyException(word.origin, this);
    }

    @Override
    public void removeWord(String originWord) {
        if(this.words.remove(originWord) == null)
            throw new WordNotExistVocabularyException(originWord, this);
    }

    @Override
    public void replaceWord(String originWord, String newWord) {
        // get word(translations) object
        var word = this.words.get(originWord);

        // if word(translations) not found in map: replacement impossible - throw exception
        if(word == null)
            throw new WordNotExistVocabularyException(originWord, this);

        // remove old key from map
        this.words.remove(originWord);

        // add new key with old translations
        this.addWord(newWord, word.getTranslations());
    }

    @Override
    public void addTranslation(String originWord, String translation) {
        // get word(translations) object
        var word = this.words.get(originWord);

        if(word == null)
            throw new WordNotExistVocabularyException(originWord, this);

        word.addTranslation(translation);
    }

    @Override
    public void removeTranslation(String originWord, String translation) {
        // get word(translations) object
        var word = this.words.get(originWord);

        if(word == null)
            throw new WordNotExistVocabularyException(originWord, this);

        word.removeTranslation(translation);
    }

    @Override
    public void replaceTranslation(String originWord, String translation, String newTranslation) {
        // get word(translations) object
        var word = this.words.get(originWord);

        if(word == null)
            throw new WordNotExistVocabularyException(originWord, this);

        word.replaceTranslation(translation, newTranslation);
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "originLanguage='" + originLanguage + '\'' +
                ", translateLanguage='" + translateLanguage + '\'' +
                ", count words=" + words.size() +
                '}';
    }
}
