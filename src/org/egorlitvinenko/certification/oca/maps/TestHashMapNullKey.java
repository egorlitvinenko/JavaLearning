package org.egorlitvinenko.certification.oca.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Egor Litvinenko on 25.01.17.
 */
public class TestHashMapNullKey {

    public static void main(String[] args) {
        Map<Object, Boolean> map = new HashMap<>();
        map.put(null, null);
        map.get(null);
        npe(map);
    }

    public static boolean npe(Map<Object, Boolean> map) {
        return map.get(null);
    }

}
