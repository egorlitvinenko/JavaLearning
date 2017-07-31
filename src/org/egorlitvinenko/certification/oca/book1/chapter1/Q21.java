package org.egorlitvinenko.certification.oca.book1.chapter1;

/**
 * Created by Egor Litvinenko on 25.01.17.
 */
public class Q21 {
    int a;
    {
        System.out.println("Instance initialization: " + a);
    }

    public Q21() {
        a = 2;
    }

    public int Q21() {
        return ++a;
    }

    public static void main(String[] args) {
        Q21 q21 = new Q21();
        System.out.println("After constructor: " + q21.a);
        q21.Q21();
        System.out.println("After call: " + q21.a);
        q21.Q21();
        System.out.println("After call: " + q21.a);
    }


}
