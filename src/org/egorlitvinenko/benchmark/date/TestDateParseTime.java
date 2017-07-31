package org.egorlitvinenko.benchmark.date;

import org.egorlitvinenko.benchmark.AbstractATest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Egor Litvinenko
 */
public class TestDateParseTime extends AbstractATest {

    String[] values;
    LocalDateTime[] result;

    @Override
    protected void setup() {
        values = new String[5_000_000];
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
    protected void cleanup() {
        System.out.println(result.length);
    }

    public static void main(String[] args) {
        new TestDateParseTime().doTest();
    }

}
