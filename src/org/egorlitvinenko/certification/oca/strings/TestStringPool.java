package org.egorlitvinenko.certification.oca.strings;

/**
 * Created by Egor Litvinenko on 09.02.17.
 */
public class TestStringPool {

    public static void main(String[] args) {
        String a = "name";
        String b = new String("name");

        System.out.println(a == b);
        System.out.println(a.equals(b));
        b = b.intern();
        System.out.println(a == b);
    }

}
