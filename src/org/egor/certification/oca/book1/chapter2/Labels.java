package org.egor.certification.oca.book1.chapter2;

/**
 * Created by Egor Litvinenko on 04.02.17.
 */
public class Labels {

    public static void main(String[] args) {
        PARENT_LOOP: for (int i = 0; i < 10; ++i) {
            CHILD_LOOP: for (int j = 9; j >= i; j--) {
                int a = j;
                a = - --a;
                System.out.println(i + ", " + j + ", " + a);
                if ((a + i + j) % 2 == 0) {
                    continue PARENT_LOOP;
                } else if (a + i > 0) {
                    break PARENT_LOOP;
                }
            }
        }
    }

}
