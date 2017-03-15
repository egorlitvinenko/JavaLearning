package org.egor.certification.oca.book1.chapter6;

/**
 * @author Egor Litvinenko
 */
class Test2 {

    public static void main(String[] args) {
        System.out.println(exceptions());
    }

    public static String exceptions() {
        String result = "";
        String v = null;
        try {
            try {
                result += "before";
                v.length();
                result += "after";
            } catch (NullPointerException e) {
                result += "catch";
                throw new RuntimeException();
            } finally {
                result += "finally";
                throw new Exception();
            }
        } catch (Exception e) {
            result += "done";
        }
        return result;
    }

}
