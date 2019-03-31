import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void test1(){
        double IntegerBetweenZeroAndN = StdRandom.uniform();
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
        if(IntegerBetweenZeroAndN > 0.5){
            stu.addFirst(1);
            sol.addFirst(1);
            assertEquals("\n addFirst(1)",stu,sol);
        } else{
            stu.addLast(1);
            sol.addLast(1);
            assertEquals("\n addLast(1)",stu,sol);
        }

    }
}

