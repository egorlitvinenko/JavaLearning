package org.egorlitvinenko.benchmark.number;

import org.egorlitvinenko.benchmark.AbstractABTest;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author Egor Litvinenko
 */
public class TestSubtractDoubleVsBigDecimal extends AbstractABTest {

    private Double[] doubleValues;
    private BigDecimal[] decimalValues;

    private Double lastDouble;
    private BigDecimal lastBigDecimal;

    @Override
    protected void setup() {
        final int size = 1_000_000;
        doubleValues = new Double[size];
        decimalValues = new BigDecimal[doubleValues.length];
        Random random = new Random();
        for (int i = 0; i < doubleValues.length; ++i) {
            doubleValues[i] = random.nextDouble() * Long.MAX_VALUE;
            decimalValues[i] = new BigDecimal(doubleValues[i]);
        }
    }

    @Override
    protected void doA() {
        lastDouble = 0.;
        for (int i = 0; i < doubleValues.length; ++i) {
            lastDouble += doubleValues[i] - doubleValues[doubleValues.length - i - 1];
        }
    }

    @Override
    protected void doB() {
        lastBigDecimal = BigDecimal.ZERO;
        for (int i = 0; i < decimalValues.length; ++i) {
            lastBigDecimal = lastBigDecimal.add(decimalValues[i].subtract(decimalValues[decimalValues.length - 1 - i]));
        }
    }

    @Override
    protected void cleanup() {
        System.out.println("Cleanup");
        System.out.println("" + lastDouble);
        System.out.println("" + lastBigDecimal);
        doubleValues = null;
        decimalValues = null;
    }

    public static void main(String[] args) {
        new TestSubtractDoubleVsBigDecimal().doTest();
    }

}
