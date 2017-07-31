package org.egorlitvinenko.benchmark.date;

import org.egorlitvinenko.benchmark.AbstractATest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Egor Litvinenko
 */
public class TestDateParseVsPositionalTime2 extends AbstractATest {

    String[] values;
    int[] result;

    @Override
    protected void setup() {
        values = new String[5_000_000];
        result = new int[values.length];
        for (int i = 0; i < values.length; ++i) {
            values[i] = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        }
    }

    @Override
    protected void doA() {
        char[] twoBuffer = new char[2];
        char[] fourBuffer = new char[4];
        char[] threeBuffer = new char[3];
        int year, month, day, hour, minute, seconds, msec;
        for (int i = 0; i < values.length; ++i) {
            char[] string = values[i].toCharArray();
            // 2(0)017-0(5)4-2(8)1T1(11)3:4(14)7:4(17)8.8(20)96
            System.arraycopy(string, 0, fourBuffer, 0, 4);
            year = four(fourBuffer);
            System.arraycopy(string, 5, twoBuffer, 0, 2);
            month = two(twoBuffer);
            System.arraycopy(string, 8, twoBuffer, 0, 2);
            day = two(twoBuffer);
            System.arraycopy(string, 11, twoBuffer, 0, 2);
            hour = two(twoBuffer);
            System.arraycopy(string, 14, twoBuffer, 0, 2);
            minute = two(twoBuffer);
            System.arraycopy(string, 17, twoBuffer, 0, 2);
            seconds = two(twoBuffer);
            result[i] = year + day + month + hour + minute + seconds; //LocalDateTime.of(year, month, day, hour, minute, seconds);
        }
    }

    private static final int TWO_SUBTRACT = '0' * 11;
    private static final int DOUBLE_TWO_SUBTRACT = 2 * TWO_SUBTRACT;

    private static int two(char[] two) {
        return two[0] * 10 + two[1] - TWO_SUBTRACT;
    }

    private static int four(char[] four) {
        return 100 * (four[0] * 10 + four[1]) + (four[2] * 10 + four[3]) - DOUBLE_TWO_SUBTRACT;
    }

    public static void main(String[] args) {
        new TestDateParseVsPositionalTime2().doTest();
    }

}
