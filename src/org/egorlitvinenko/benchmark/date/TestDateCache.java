package org.egorlitvinenko.benchmark.date;

import org.egorlitvinenko.benchmark.AbstractABTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Egor Litvinenko
 */
public class TestDateCache extends AbstractABTest {

    private String[] dateStrings = null;
    private LocalDate[] dates = null;
    private Map<String, LocalDate> dateCache = null;

    @Override
    protected void setup() {
        dateStrings = new String[100000];
        dates       = new LocalDate[dateStrings.length];
        int theSameDate = 100;
        LocalDate date = LocalDate.now();
        for (int i = 0, j = 0; i < dateStrings.length; ++i) {
            dateStrings[i] = date.plusDays(j).toString();
            if (i % theSameDate == 0) {
                ++j;
            }
        }
        dateCache = new HashMap<>();
    }

    @Override
    protected void doA() {
        for(int i = 0; i < dateStrings.length; ++i) {
            dates[i] = getDate(dateStrings[i], dateCache);
        }
    }

    @Override
    protected void doB() {
        for(int i = 0; i < dateStrings.length; ++i) {
            dates[i] = LocalDate.parse(dateStrings[i]);
        }
    }

    private static LocalDate getDate(String value, Map<String, LocalDate> cache) {
        LocalDate result = cache.get(value);
        if (null == result) {
            result = LocalDate.parse(value);
            cache.put(value, result);
        }
        return result;
    }

    @Override
    protected void cleanup() {
        System.out.println("Cleanup " + dates.length);
        System.out.println("Unique dates in cache " + dateCache.size());
        dates = null;
        dateStrings = null;
        dateCache = null;
    }

    public static void main(String[] args) {
        new TestDateCache().doTest();
    }

}


// Last run
//        Force JVM...
//        Force JVM...
//        Cleanup 100000
//        Unique dates in cache 1001
//
//        DIRECT:
//        StopWatch 'Test A': running time (millis) = 55
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00008  015%
//        00006  011%
//        00005  009%
//        00005  009%
//        00005  009%
//        00005  009%
//        00005  009%
//        00005  009%
//        00006  011%
//        00005  009%
//
//        StopWatch 'Test B': running time (millis) = 1060
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00106  010%
//        00100  009%
//        00102  010%
//        00111  010%
//        00106  010%
//        00106  010%
//        00106  010%
//        00126  012%
//        00099  009%
//        00098  009%
//
//        Average A = 5.5
//        Average B = 106.0
//        A is faster then B - true
//
//        REVERSE:
//        StopWatch 'Test B': running time (millis) = 1031
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00099  010%
//        00099  010%
//        00108  010%
//        00100  010%
//        00099  010%
//        00099  010%
//        00098  010%
//        00122  012%
//        00100  010%
//        00107  010%
//
//        StopWatch 'Test A': running time (millis) = 52
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00005  010%
//        00005  010%
//        00005  010%
//        00006  012%
//        00005  010%
//        00005  010%
//        00005  010%
//        00006  012%
//        00005  010%
//        00005  010%
//
//        Reverse Average A = 5.2
//        Reverse Average B = 103.1
//        Reverse A is faster then B - true
//        Cleanup 100000
//        Unique dates in cache 1001
//        Disconnected from the target VM, address: '127.0.0.1:55941', transport: 'socket'
//
//        Process finished with exit code 0