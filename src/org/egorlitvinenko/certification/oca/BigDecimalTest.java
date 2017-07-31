package org.egorlitvinenko.certification.oca;

import java.math.BigDecimal;

/**
 * @author Egor Litvinenko
 */
public class BigDecimalTest {

    public static void main(String[] args) {
//        test(null);
        test("");
    }

    public static void test(String value) {
        new BigDecimal(value);
    }

}
