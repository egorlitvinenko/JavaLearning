package org.egorlitvinenko.certification.oca.classes.multi;

/**
 * @author Egor Litvinenko
 */
abstract class abstractF implements ID, IA {

    @Override
    public Long method() {
        return 2l;
    }

    @Override
    public void print() {
        System.out.println("F");
    }

}
