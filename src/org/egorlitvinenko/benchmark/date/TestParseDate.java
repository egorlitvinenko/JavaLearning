package org.egorlitvinenko.benchmark.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Egor Litvinenko
 */
public class TestParseDate {

    public static void main(String[] args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.from(formatter.parse("2014-01-04 08:45:19"));
        System.out.println(dateTime);
    }

}
