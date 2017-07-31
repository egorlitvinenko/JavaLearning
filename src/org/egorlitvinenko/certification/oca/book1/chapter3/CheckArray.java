package org.egorlitvinenko.certification.oca.book1.chapter3;

/**
 * @author Egor Litvinenko
 */
public class CheckArray {

    public static void main(String[] args) {
        Object[][][] objects = new Object[4][1][5];
        for (int i = 0; i < objects.length; ++i) {
            System.out.println("Length of " + i + " : " + objects[i].length);
            for (int j = 0; j < objects[i].length; ++j) {
                System.out.print("Length of " + i + ", " + j + " : " + objects[i][j].length + " | ");
                for (int k = 0; k < objects[i][j].length; ++k) {
                    System.out.print(objects[i][j][k] + " ");
                }
                System.out.println();
            }
        }

    }

}
