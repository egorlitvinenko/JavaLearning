package org.egorlitvinenko.certification.oca.book1.chapter3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Egor Litvinenko
 */
public class SortStrings {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("8", "81", "30", "3A", "FF");
        Collections.sort(items);
        System.out.println(items);
        System.out.println(Collections.binarySearch(items, "8"));
        System.out.println(Collections.binarySearch(items, "3A"));
        System.out.println(Collections.binarySearch(items, "4F"));
    }

}
