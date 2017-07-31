package org.egorlitvinenko.benchmark.date;

/**
 * @author Egor Litvinenko
 */
public class TestDateParseVsPositionalTime3 extends TestDateParseVsPositionalTime2 {

    @Override
    protected void doA() {
        int year, month, day, hour, minute, seconds;
        for (int i = 0; i < values.length; ++i) {
            // 2(0)017-0(5)4-2(8)1T1(11)3:4(14)7:4(17)8.8(20)96
            year = four(values[i]);
            month = two(values[i], 5);
            day = two(values[i], 8);
            hour = two(values[i], 11);
            minute = two(values[i], 14);
            seconds = two(values[i], 17);
            result[i] = year + day + month + hour + minute + seconds;
        }
    }

    private static final int TWO_SUBTRACT = '0' * 11;

    private static int two( final String s, final int from )
    {
        return s.charAt( from ) * 10 + s.charAt( from + 1 ) - TWO_SUBTRACT;
    }

    private static int four( final String s )
    {
        return 100 * two( s, 0 ) + two( s, 2 );
    }

    public static void main(String[] args) {
        new TestDateParseVsPositionalTime2().doTest();
    }

}
