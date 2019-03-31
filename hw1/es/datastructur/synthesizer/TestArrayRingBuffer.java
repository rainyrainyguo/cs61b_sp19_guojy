package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(5);
        assertTrue(arb.isEmpty());
        arb.enqueue(1);
        assertEquals(1, arb.fillCount());
        arb.enqueue(2);
        assertEquals(1, arb.peek());
    }
}
