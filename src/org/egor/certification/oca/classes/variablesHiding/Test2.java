package org.egor.certification.oca.classes.variablesHiding;

/**
 * @author Egor Litvinenko
 */
class Test2 {

    public static void main(String[] args) {
        B b1 = new B();
        A b2 = new B();
        System.out.println(b2.length);
        System.out.println(b1.length);
        System.out.println(b2.getLength());
        System.out.println(b1.getLength());
    }

}
