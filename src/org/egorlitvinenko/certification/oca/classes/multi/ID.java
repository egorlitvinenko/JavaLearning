package org.egorlitvinenko.certification.oca.classes.multi;

/**
 * @author Egor Litvinenko
 */
interface ID {

    default Long method() {
        return 1l;
    }

    default void print() {
        System.out.println("ID");
    }

}
