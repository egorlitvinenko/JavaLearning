package org.egorlitvinenko.certification.oca.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.IntStream;

/**
 * @author Egor Litvinenko
 */
public class TestFailFast {

    public static void main(String[] args) {
        failFast(concurrentSkipListSet(), 2);
        notFailFast(arrayList(), 2);
        failFast(arrayList(), 2);
    }

    static List<Integer> arrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.range(1, 5). forEach(e -> list.add(e));
        return list;
    }

    static ConcurrentSkipListSet<Integer> concurrentSkipListSet() {
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();
        IntStream.range(1, 5). forEach(e -> set.add(e));
        return set;
    }

    static void notFailFast(Collection<Integer> collection, Integer value) {
        System.out.println("Not fail fast " + collection.getClass() + " before: " + collection);
        for (Integer item : collection) {
            if (item.equals(value)) {
                collection.remove(item);
                break;
            }
        }
        System.out.println("Not fail fast " + collection.getClass() + " after: " + collection);
    }

    static void failFast(Collection<Integer> collection, Integer value) {
        System.out.println("Fail fast with " + collection.getClass() + " before: " + collection);
        for (Integer item : collection) {
            if (item.equals(value)) {
                collection.remove(item);
            }
        }
        System.out.println("Fail fast " + collection.getClass() + " after: " + collection);
    }

}
