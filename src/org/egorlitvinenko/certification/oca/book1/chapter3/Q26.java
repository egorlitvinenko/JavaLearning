package org.egorlitvinenko.certification.oca.book1.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Egor Litvinenko
 */
public class Q26 {

    public static void main(String[] args) {
        List<Integer> ages = new ArrayList<>();
        ages.add(Integer.parseInt("1"));
        ages.add(Integer.valueOf("2"));
        ages.add(7);
        ages.add(null);
        for (int age : ages) {
            System.out.println(age);
        }
    }

}
