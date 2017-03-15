package org.egor.certification.oca.valueOf;

/**
 * Created by Egor Litvinenko on 12.02.17.
 */
public class TestBooleanValueOf {

    public static void main(String[] args) {
        Boolean a = new Boolean(true);
        Boolean b = Boolean.TRUE;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

}
