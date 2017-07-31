package org.egorlitvinenko.certification.oca.book1.chapter1;

/**
 * Created by Egor Litvinenko on 25.01.17.
 */
public class Q3 {
    short numPets = 5;
    long a = 1;
    Long b = 1l;
//    Long c = 1;
    int d = 1;
    byte c = -1;
    char ch = 1, ch2 = 'A';
    char default_ch, dch = ' ';
//    int numGrains = 0.5;

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.default_ch);
        System.out.println(q3.dch);
        System.out.println(args.length > 0 ? args[0] : "no args :(");
        if (args.length > 0 && args[0].equals("true")) {
            boolean T = Boolean.valueOf(args[0]);
            System.out.println("And it is too - " + T);
        }
    }

}
