class B extends A {
    public void m2() { System.out.println("Bm2-> " + x); }
    //public void m2super() { System.out.println("Bm2-> " + super.x); }
    //public void m2A() { System.out.println("Bm2-> " + A.x); }
    public void m2(int y) { System.out.println("Bm2y-> " + y); }
    public void m3() { System.out.println("Bm3-> " + "called"); }
}

