package task3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringManipulatorTest {
    @Test
    public void StringPalindromeTest() {
        var t = StringManipulator.isStringPalindrome("Уму - мінімуму!");
        assertTrue(t);
    }
}
