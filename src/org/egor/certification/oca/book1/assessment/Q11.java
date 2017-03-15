package org.egor.certification.oca.book1.assessment;

/**
 * Created by Egor Litvinenko on 19.01.17.
 */
public class Q11 {

    public static void main(String[] args) {
        int x = 5, j = 0;
        OUTER: for(int i = 0; i < 3;) {
            System.out.println(i);
            INNER:
            do {
                x++;
                i++;
                if (x > 10) break INNER;
                x += 4;
                j++;
            } while (j <= 2);
        }
        System.out.println(x);
    }

}
