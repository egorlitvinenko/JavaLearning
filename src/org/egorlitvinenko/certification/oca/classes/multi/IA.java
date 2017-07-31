package org.egorlitvinenko.certification.oca.classes.multi;

/**
 * @author Egor Litvinenko
 */
interface IA {

    default Number method() {
        return 1;
    }

    default void print() {
        System.out.println("IA");
    }

}
