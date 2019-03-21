public class TestBody {

    /**
     *  Tests Body pairwise force.
     */
    public static void main(String[] args) {
        checkBody();
    }
    /**
     *  Checks the Body class.
     */
    private static void checkBody() {
        System.out.println("Checking Body...");

        Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b2 = new Body(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");

        System.out.println("Pairwise force between two bodies: "+b1.calcForceExertedBy(b2));
    }
}
