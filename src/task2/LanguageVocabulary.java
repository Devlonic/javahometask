package task2;

import java.util.List;

public interface LanguageVocabulary {
    List<String> translate(String originalWord);

    boolean addWord(String word, String firstTranslation);
    boolean removeWord(String word);
    boolean changeWord(String word, String newWord);

    boolean addWordTranslation(String word, String newTranslation);
    boolean removeWordTranslation(String word, String translation);
    boolean changeWordTranslation(String word, String oldTranslation, String newTranslation);

    List<String> getTopPopularWords();
    List<String> getTopUnPopularWords();
}
