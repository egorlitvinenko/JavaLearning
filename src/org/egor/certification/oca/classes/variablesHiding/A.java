package org.egor.certification.oca.classes.variablesHiding;

/**
 * @author Egor Litvinenko
 */
class A {

    protected int a = 1;

    int length = 2;

    void print() {
        System.out.println(a);
    }

    int getLength() {
        return length;
    }
}
