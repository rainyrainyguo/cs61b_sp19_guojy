import static org.junit.Assert.*;
import org.junit.Test;

public class TestUF {
    @Test
    public void test1() {
        UnionFind u = new UnionFind(9);
        u.union(2,3);
        u.union(1,2);
        u.union(5,7);
        u.union(8,4);
        u.union(7,2);
        assertEquals(3, u.find(3));
    }
}