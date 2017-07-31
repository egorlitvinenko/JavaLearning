package org.egorlitvinenko.certification.oca.book1.chapter4;

/**
 * @author Egor Litvinenko
 */
public class TestVarargs {

    static void method(int a) {

    }

    static void method(int... c) {
        System.out.println(c.length);
    }

    public static void main(String[] args) {
        method(1);
        method(1, 2);
    }

}
