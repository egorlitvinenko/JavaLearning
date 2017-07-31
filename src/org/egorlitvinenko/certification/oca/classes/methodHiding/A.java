package org.egorlitvinenko.certification.oca.classes.methodHiding;

/**
 * @author Egor Litvinenko
 */
public class A {

    public static void method1() {
        System.out.println("A1");
    }

    public void method2() {
        System.out.println("A2");
    }

}
