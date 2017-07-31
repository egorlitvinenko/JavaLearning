package org.egorlitvinenko.certification.oca.classes.methodHiding;

/**
 * @author Egor Litvinenko
 */
public class Test {

    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        B b2 = new B();
        a.method1();
        b.method1();
        b2.method1();
        a.method2();
        b.method2();
    }

}
