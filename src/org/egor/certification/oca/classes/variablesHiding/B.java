package org.egor.certification.oca.classes.variablesHiding;

/**
 * @author Egor Litvinenko
 */
class B extends A {

    private int a = 2;

    int length = 5;

    @Override
    void print() {
        System.out.println(a + ", " + super.a);
    }

    @Override
    int getLength() {
        return length;
    }

}
