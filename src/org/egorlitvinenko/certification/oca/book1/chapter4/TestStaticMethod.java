package org.egorlitvinenko.certification.oca.book1.chapter4;

/**
 * @author Egor Litvinenko
 */
public class TestStaticMethod {

    public void instanceMethod() {

    }

    public static void staticMethod() {}

    public static void main(String[] args) {
        TestStaticMethod m = null;
        m.staticMethod();
        m.instanceMethod();
    }

}
