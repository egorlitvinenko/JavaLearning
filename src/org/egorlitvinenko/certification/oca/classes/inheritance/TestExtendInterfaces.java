package org.egorlitvinenko.certification.oca.classes.inheritance;

/**
 * @author Egor Litvinenko
 */
public class TestExtendInterfaces {

    interface IA {

    }

    static class A {

    }

    static class B implements IA {

    }

    static class C extends A {

    }

    static class D extends C {

    }

    public static void main(String[] args) {
        System.out.println(new B() instanceof IA);
        System.out.println(new C() instanceof A);
        System.out.println(new D() instanceof A);
        System.out.println(new D() instanceof C);
    }

}
