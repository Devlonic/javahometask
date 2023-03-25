package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulator {
    public static boolean isStringPalindrome(String str) {
        if(str == null)
            return false;

        String buf = str.toLowerCase();

        var orig = buf.chars().mapToObj(c-> (char)c).filter(c->Character.isLetterOrDigit(c)).collect(Collectors.toList());

        var reversed = buf.chars().mapToObj(c-> (char)c).filter(c->Character.isLetterOrDigit(c)).collect(Collectors.toList());

        Collections.reverse(reversed);

        return orig.equals(reversed);
    }

    private static final List<Character> vowels = List.of(
            'а', 'е', 'є', 'и', 'і', 'ї', 'о', 'у', 'ю', 'я', 'a', 'e', 'i', 'o', 'u', 'y'
    );
    public static long getCountVowelsLetters(String str) {
        Predicate isVowel = (s) -> {
          return vowels.contains(Character.toLowerCase((char)s));
        };

        var x = str.
                toLowerCase().
                chars().
                mapToObj(c-> (char)c).
                filter(isVowel).
                count();
        return x;
    }


    private static final List<Character> consonants = List.of(
            'b', 'c', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 's', 't', 'v', 'x', 'z', 'h', 'r', 'w',
            'б', 'в', 'г', 'ґ', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш'
    );
    public static long getCountConsonantLetters(String str) {
        Predicate isConsonant = (s) -> {
            return consonants.contains(Character.toLowerCase((char)s));
        };

        var x = str.
                toLowerCase().
                chars().
                mapToObj(c-> (char)c).
                filter(isConsonant).
                count();
        return x;
    }

    public static int getWordCountInString(String str, String word) {
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
