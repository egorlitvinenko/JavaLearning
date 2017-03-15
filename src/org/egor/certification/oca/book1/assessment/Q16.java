package org.egor.certification.oca.book1.assessment;

/**
 * Created by Egor Litvinenko on 19.01.17.
 */
public class Q16 {

    interface A {
        default String getName() {return null; }
    }

    interface B {
        default String getName() {return null; }
    }

    static abstract class C implements A, B {
        public String getName() { return ""; }
    }

}
