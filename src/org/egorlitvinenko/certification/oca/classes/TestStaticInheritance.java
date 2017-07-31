package org.egorlitvinenko.certification.oca.classes;

/**
 * @author Egor Litvinenko
 */
public class TestStaticInheritance {

    public static void main(String[] args) {
        A.finalMethod();
        B.method();
    }

}


class A {

    static final void finalMethod() {
        System.out.println("print final A");
    }

    static void method() {
        System.out.println("print A");
    }

}

class B extends A {

    static void method() {
        A.method();
        System.out.println("print B");
    }

}
