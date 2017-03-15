package org.egor.certification.oca.book1.chapter4;

/**
 * @author Egor Litvinenko
 */
public class Q12 {
}

class RopeSwing {
    private static Rope rope1 = new Rope();
    private static Rope rope2 = new Rope();
    {
        System.out.println(rope1.length);
    }

    public static void main(String[] args) {
        rope1.length = 2;
        rope2.length = 8;
        System.out.println(Rope.length);
    }

}

class Rope {
    public static int length = 0;
}
