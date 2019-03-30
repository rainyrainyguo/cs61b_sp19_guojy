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
    public void testisPalindrome1(){
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("Noon"));
        assertFalse(palindrome.isPalindrome("cat"));
    }
    @Test
    public void testisPalindrome2(){
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("",cc));
        assertTrue(palindrome.isPalindrome("a",cc));
        assertTrue(palindrome.isPalindrome("AcdB",cc));
        assertFalse(palindrome.isPalindrome("AcA",cc));
        assertFalse(palindrome.isPalindrome("sttt",cc));
    }

    @Test
    public void test(){
        System.out.println(5/2);
    }
}     //Uncomment this class once you've created your Palindrome class.