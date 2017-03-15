package org.egor.certification.oca.dates;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author Egor Litvinenko
 */
public class TestFormats {

    public static void main(String[] args) {
        final List<FormatStyle> formatStyles = Arrays.asList(FormatStyle.SHORT, FormatStyle.MEDIUM,
                FormatStyle.LONG, FormatStyle.FULL);

        System.out.println("Test different formats ofLocalizedDateTime:");
        formatStyles.forEach(df -> {
            formatStyles.forEach(tf -> {
                try {
                    System.out.println(String.format("\tDate format - %s, Time format - %s : %s ",
                            df, tf,
                            DateTimeFormatter.ofLocalizedDateTime(df, tf).format(LocalDateTime.now())));
                } catch (Exception e) {
                    System.out.println(String.format("\tDoesnt' support %s, %s", df, tf));
                }
            });
        });

        System.out.println("Test one format ofLocalizedDateTime:");
        formatStyles.forEach(tf -> {
            try {
                System.out.println(String.format("\tFormat - %s : %s ",
                        tf, DateTimeFormatter.ofLocalizedDateTime(tf).format(LocalDateTime.now())));
            } catch (Exception e) {
                System.out.println(String.format("\tDoesnt' support %s", tf));
            }
        });

        System.out.println("Test one format ofLocalizedDate:");
        formatStyles.forEach(tf -> {
            try {
                System.out.println(String.format("\tFormat - %s : %s ",
                        tf, DateTimeFormatter.ofLocalizedDate(tf).format(LocalDateTime.now())));
            } catch (Exception e) {
                System.out.println(String.format("\tDoesnt' support %s", tf));
            }
        });

        System.out.println("Test one format ofLocalizedTime:");
        formatStyles.forEach(tf -> {
            try {
                System.out.println(String.format("\tFormat - %s : %s ",
                        tf, DateTimeFormatter.ofLocalizedTime(tf).format(LocalDateTime.now())));
            } catch (Exception e) {
                System.out.println(String.format("\tDoesnt' support %s", tf));
            }
        });

        System.out.println("Test standard formats:");
        System.out.println("\tISO_LOCAL_DATE_TIME = " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        System.out.println("\tISO_LOCAL_DATE      = " + DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDateTime.now()));
        System.out.println("\tISO_LOCAL_TIME      = " + DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now()));
        System.out.println("\tISO_DATE            = " + DateTimeFormatter.ISO_DATE.format(LocalDateTime.now()));
        System.out.println("\tISO_DATE_TIME       = " + DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));
        System.out.println("\tISO_INSTANT         = " + DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
        System.out.println("\tISO_INSTANT         = " + DateTimeFormatter.ISO_INSTANT.format(Instant.now().minus(Period.ofDays(1))));
        System.out.println("\thh:mm               = " + DateTimeFormatter.ofPattern("hh:mm", Locale.ENGLISH).format(LocalTime.now()));
        System.out.println("\thh:mm               = " + LocalTime.from(DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH).parse("15:40")));
    }

}
