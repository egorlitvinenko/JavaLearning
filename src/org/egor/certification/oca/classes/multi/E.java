package org.egor.certification.oca.classes.multi;

/**
 * @author Egor Litvinenko
 */
class E implements ID, IA, IB {

    @Override
    public Long method() {
        return null;
    }

    @Override
    public void print() {
        System.out.println("E");
    }
}
