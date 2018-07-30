import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(3);

    // Your tests go here.

    @Test
    public void testOffByN() {
        assertTrue(offByN.equalChars('a', 'd'));
        assertTrue(offByN.equalChars('d', 'a'));
        assertTrue(offByN.equalChars('r', 'u'));
        assertTrue(offByN.equalChars('u', 'r'));
        assertFalse(offByN.equalChars('q', 'o'));
    }
}
