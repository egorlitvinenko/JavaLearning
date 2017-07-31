package org.egorlitvinenko.certification.oca.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static java.lang.System.out;

/**
 * Created by Egor Litvinenko on 12.02.17.
 */
public class TestDate {

    public static final void main(String[] args) {
        out.println(LocalDate.now());
        out.println(LocalTime.now());
        out.println(LocalDateTime.now());

        out.println(LocalDate.of(2012, 1,1));
        out.println(LocalTime.of(1, 1, 1, 1));

        out.println(LocalDateTime.of(2012, 12, 31, 23, 59, 59, 10000));

        out.println(LocalDate.of(2012, 1,1).plusWeeks(10));
        out.println(LocalDate.of(2012, 1,1).plusWeeks(1));
        out.println(LocalDate.of(2012, 1,1).plusDays(1));
        out.println(LocalDate.of(2012, 1,1).plus(1, ChronoUnit.YEARS));
        out.println(LocalDate.of(2012, 1,1).minus(2, ChronoUnit.DAYS));
        out.println(LocalTime.of(1, 1, 1, 1).plus(2, ChronoUnit.SECONDS));
    }

}
