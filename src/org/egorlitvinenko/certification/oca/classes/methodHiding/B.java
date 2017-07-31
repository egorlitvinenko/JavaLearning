package org.egorlitvinenko.certification.oca.classes.methodHiding;

/**
 * @author Egor Litvinenko
 */
public class B extends A {

    public static void method1() {
        System.out.println("B1");
    }

    public void method2() {
        System.out.println("B2");
    }


}
