package org.egor.certification.oca.loops;

/**
 * Created by Egor Litvinenko on 04.02.17.
 */
public class InfiniteFloat {

    public static void main(String[] args) {
        goodAbsComparison();
        infiniteStrictfpComparison();
    }

    static void goodAbsComparison() {
        float x = 0.f;
        // or just x < 0.1
        while (Math.abs(x - 1.1) < 0.01) {
            System.out.println(x);
            x += 0.1f;
        }
    }

    static strictfp void infiniteStrictfpComparison() {
        float x = 0.f;
        int i = 0;
        while (x != 1.1f && i++ < 1000) {
            System.out.println(x);
            x += 0.1f;
        }
        System.out.println("x = " + x);
    }

    static void infiniteDoubleComparison() {
        float x = 0.f;
        while (x != 1.1) {
            System.out.println(x);
            x += 0.1f;
        }
    }

    static void infiniteFloatComparison() {
        float x = 0.f;
        while (x != 1.1f) {
            System.out.println(x);
            x += 0.1f;
        }
    }

}
