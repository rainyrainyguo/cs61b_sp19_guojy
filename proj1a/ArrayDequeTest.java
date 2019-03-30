import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void test(){
        ArrayDeque<Integer> a = new ArrayDeque();
        a.addFirst(1);
        a.addFirst(2);
        a.addLast(3);
        a.addLast(4);
        a.addFirst(5);
        a.addFirst(6);
        a.addLast(7);
        a.addLast(8);
        a.addFirst(9);
        a.addFirst(10);
        a.printDeque();
        a.removeLast();
        a.printDeque();
        a.removeFirst();
        a.printDeque();
        System.out.println(a.get(0));
        System.out.println(a.get(7));
        System.out.println(a.get(4));
        ArrayDeque<Integer> b = new ArrayDeque(a);
        b.printDeque();
        ArrayDeque<String> c = new ArrayDeque(a);
        c.printDeque();
    }

    @Test
    public void IsEmptyTest() {
        System.out.println("Perform IsEmptyTest1");
        ArrayDeque<Integer> array = new ArrayDeque<>();
        // Test isEmpty()
        assertEquals(array.isEmpty(), true);

        System.out.println("Perform IsEmptyTest2");

        ArrayDeque<Integer> array2 = new ArrayDeque<>();
        array2.addFirst(234);
        array2.addLast(432);
        // Test isEmpty()
        assertEquals(array2.isEmpty(), false);

    }

}
