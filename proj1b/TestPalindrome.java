import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("anna"));
        assertTrue(palindrome.isPalindrome("anbna"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("Anna"));
    }

    @Test
    public void testisPalindromeCC() {
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("abdab", offByOne));
        assertTrue(palindrome.isPalindrome("abab", offByOne));
        assertFalse(palindrome.isPalindrome("anna", offByOne));
    }

    @Test
    public void testisPalindromeCCN() {
        CharacterComparator offBy0 = new OffByN();
        CharacterComparator offBy1 = new OffByN(1);
        CharacterComparator offBy2 = new OffByN(2);
        CharacterComparator offBy3 = new OffByN(3);
        assertTrue(palindrome.isPalindrome("anbna", offBy0));
        assertTrue(palindrome.isPalindrome("anob", offBy1));
        assertTrue(palindrome.isPalindrome("anspc", offBy2));
        assertTrue(palindrome.isPalindrome("aqnd", offBy3));
        assertFalse(palindrome.isPalindrome("annb", offBy0));
        assertFalse(palindrome.isPalindrome("anna", offBy1));
        assertFalse(palindrome.isPalindrome("andna", offBy2));
        assertFalse(palindrome.isPalindrome("anna", offBy3));
    }
}
