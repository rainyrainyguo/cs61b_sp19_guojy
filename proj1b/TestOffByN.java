import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testequalChars(){
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a','f'));
        assertTrue(offBy5.equalChars('f','a'));
        assertFalse(offBy5.equalChars('a','b'));
    }

} //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. *
