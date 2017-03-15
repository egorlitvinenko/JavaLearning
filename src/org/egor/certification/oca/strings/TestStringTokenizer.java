package org.egor.certification.oca.strings;

/**
 * Created by Egor Litvinenko on 04.02.17.
 */
public class TestStringTokenizer {

    public static void main(String[] args) {
        String str = "a,b,c,d,";
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        System.out.println("countTokens = " + stringTokenizer.countTokens());
        while(stringTokenizer.hasMoreElements()) {
            System.out.println(stringTokenizer.nextToken());
        }
    }

}
