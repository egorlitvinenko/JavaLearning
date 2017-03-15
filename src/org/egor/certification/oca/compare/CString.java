package org.egor.certification.oca.compare;

/**
 * Created by Egor Litvinenko on 25.01.17.
 */
public class CString {

    public static void main(String[] args) {
        String s1 = new String("1");
        String s2 = new String("1");
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
        System.out.println("With \"==\" :" + (s1 == "1") + ", " + (s2 == "1") + ", " + (s1 == s2));
        System.out.println("With equals: " + s1.equals("1") + ", " + s2.equals("1") + ", " + s2.equals(s1));
    }
}
