package org.egorlitvinenko.benchmark.date;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * @author Egor Litvinenko
 */
public class TestFastDateFormat extends TestDateParseVsPositionalTime2 {

    FastDateFormat fastDateFormat = FastDateFormat.getDateTimeInstance(FastDateFormat.FULL, FastDateFormat.FULL);

    @Override
    protected void doA() {
        for (int i = 0; i < values.length; ++i) {
            // 2(0)017-0(5)4-2(8)1T1(11)3:4(14)7:4(17)8.8(20)96
            Date date = null;
            try {
                date = fastDateFormat.parse(values[i]);
                result[i] = date.getDay(); //LocalDateTime.of(year, month, day, hour, minute, seconds);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new TestFastDateFormat().doTest();
    }

}
