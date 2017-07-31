package org.egorlitvinenko.benchmark.date;

import org.egorlitvinenko.benchmark.AbstractABTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Egor Litvinenko
 */
public class TestDateParseVsPositionalTime extends AbstractABTest {

    String[] values;
    LocalDateTime[] result;

    @Override
    protected void setup() {
        values = new String[1_000_000];
        result = new LocalDateTime[values.length];
        for (int i = 0; i < values.length; ++i) {
            values[i] = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        }
    }

    @Override
    protected void doA() {
        for (int i = 0; i < values.length; ++i) {
            result[i] = LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(values[i]));
        }
    }

    @Override
    protected void doB() {
        char[] twoBuffer = new char[2];
        char[] fourBuffer = new char[4];
        char[] threeBuffer = new char[3];
        int year, month, day, hour, minute, seconds, msec;
        for (int i = 0; i < values.length; ++i) {
            char[] string = values[i].toCharArray();
            // 2(0)017-0(5)4-2(8)1T1(11)3:4(14)7:4(17)8.8(20)96
            System.arraycopy(string, 0, fourBuffer, 0, 4);
            year = Integer.valueOf(new String(fourBuffer));
            System.arraycopy(string, 5, twoBuffer, 0, 2);
            month = Integer.valueOf(new String(twoBuffer));
            System.arraycopy(string, 8, twoBuffer, 0, 2);
            day = Integer.valueOf(new String(twoBuffer));
            System.arraycopy(string, 11, twoBuffer, 0, 2);
            hour = Integer.valueOf(new String(twoBuffer));
            System.arraycopy(string, 14, twoBuffer, 0, 2);
            minute = Integer.valueOf(new String(twoBuffer));
            System.arraycopy(string, 17, twoBuffer, 0, 2);
            seconds = Integer.valueOf(new String(twoBuffer));
            result[i] = LocalDateTime.of(year, month, day, hour, minute, seconds);
        }
    }

    @Override
    protected void cleanup() {
        System.out.println(result.length);
    }

    public static void main(String[] args) {
        new TestDateParseVsPositionalTime().doTest();
    }

}
