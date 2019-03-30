class test {
    public static void main (String[] args) {
        //B a0 = new A(); Dynamic type must be B or subclass of B
        //a0.m1(); cascading: prev line failed, so a0 can't be initialized
        //a0.m2(16); cascading: prev line failed, so a0 can't be initialized

        A b0 = new B();
        //System.out.println(b0.x); [prints "5"]
        //b0.m1(); [prints "Am1-> 5"]
        //b0.m2(); [prints "Bm2-> 5"]
        //b0.m2(61);//m2 (int y) not defined in static type of b0
        ((B)b0).m2(61); //cast b0 to B in static type
        B b1 = new B();
        b1.m2(61); //[prints "Bm2y-> 61"]
        b1.m3(); //[prints "Bm3-> called"]
        A c0 = new C();
//        Inheritance 5
        c0.m2(); //[prints "cm2-> 5"]
        //C c1 = (A) new C(); //Can't assign c1 to an A
        A a1 = (A) c0;
        C c2 = (C) a1;
        c2.m3(); //[print Bm3-> called]
//        c2.m4(); C.m4() is invalid
        c2.m5(); //[print Cm5-> 6]
        ((C) c0).m3(); //[print Bm3-> called]
//        (C) c0.m3(); NOT RUNTIME ERROR This would case the result of what the method returns and
//        it returns void therefore compile-time error
        b0.update();
        b0.m1(); //[print Am1-> 99]
    }
}