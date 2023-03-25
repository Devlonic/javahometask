package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringManipulatorTest {
    @Test
    public void StringPalindromeTest() {
        var t = StringManipulator.isStringPalindrome("Уму - мінімуму");
        assertTrue(t);

        var f = StringManipulator.isStringPalindrome("Уму - мінімуму111");
        assertFalse(f);
    }

    @Test
    public void getCountVowelsLetters_Test() {
        var c = StringManipulator.getCountVowelsLetters("FFаеєиіїоуюяaeiouyVV003355++==");
        assertEquals(16, c);
    }

    @Test
    public void getCountConsonantsLetters_Test() {
        var c = StringManipulator.getCountConsonantLetters("bcdfgjklmnpqstvxzhrwбвгґджзйклмннпрстфхцчш");
        assertEquals(42, c);
    }

    @Test
    public void getWordCountInString_Test() {
        var c = StringManipulator.getWordCountInString("Lorem Ipsum is simply dummy Lorem text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when anm lorem unknown printer took a galley of type and scrambled it to make a type specimen book. Lorem", "lorem");
        assertEquals(5, c);
    }
}
