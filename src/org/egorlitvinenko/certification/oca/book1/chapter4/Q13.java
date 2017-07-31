package org.egorlitvinenko.certification.oca.book1.chapter4;

/**
 * @author Egor Litvinenko
 */
public class Q13 {

    private static final String leftRope;
    private static final String rightRope;
//    private static final String bench; DOES NOT COMPILE
    private static final String name = "name";

    static {
        leftRope = "leftRope";
        rightRope = "rightRope";
    }

    static {
//        name = "name"; DOES NOT COMPILE
//        rightRope = "rightRope2"; DOES NOT COMPILE
    }


    public static void main(String[] args) {
//        bench = "bench"; DOES NOT COMPILE
    }

}
