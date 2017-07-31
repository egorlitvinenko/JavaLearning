package org.egorlitvinenko.benchmark.number;

import org.egorlitvinenko.benchmark.AbstractABTest;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author Egor Litvinenko
 */
public class TestDeserializeAndSubtractDoublePrimitiveVsBigDecimal extends AbstractABTest {


    private String[] stringDoubleValue;

    private double lastDouble;
    private BigDecimal lastBigDecimal;

    @Override
    protected void setup() {
        final int size = 1_000_000;
        stringDoubleValue = new String[size];
        Random random = new Random();
        for (int i = 0; i < stringDoubleValue.length; ++i) {
            stringDoubleValue[i] = String.valueOf((random.nextDouble() * Long.MAX_VALUE));
        }
    }

    @Override
    protected void doA() {
        for (int i = 0; i < stringDoubleValue.length; ++i) {
            double valueOne = Double.parseDouble(stringDoubleValue[i]),
                    valueTwo = Double.parseDouble(stringDoubleValue[stringDoubleValue.length - i - 1]);
            lastDouble = valueOne - valueTwo;
        }
    }

    @Override
    protected void doB() {
        for (int i = 0; i < stringDoubleValue.length; ++i) {
            BigDecimal valueOne = new BigDecimal(stringDoubleValue[i]),
                    valueTwo = new BigDecimal(stringDoubleValue[stringDoubleValue.length - i - 1]);
            lastBigDecimal = valueOne.subtract(valueTwo);
        }
    }

    @Override
    protected void cleanup() {
        System.out.println("Cleanup");
        System.out.println("" + lastDouble);
        System.out.println("" + lastBigDecimal);
        stringDoubleValue = null;
    }

    public static void main(String[] args) {
        new TestDeserializeAndSubtractDoublePrimitiveVsBigDecimal().doTest();
    }


}


//        Force JVM...
//        Force JVM...
//        Cleanup
//        1.4768539767522304E18
//        1.4768539767522304E+18
//
//        DIRECT:
//        StopWatch 'Test A': running time (millis) = 5684
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00926  016%
//        00536  009%
//        00532  009%
//        00540  010%
//        00534  009%
//        00521  009%
//        00524  009%
//        00526  009%
//        00521  009%
//        00524  009%
//
//        StopWatch 'Test B': running time (millis) = 5057
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00499  010%
//        00519  010%
//        00501  010%
//        00509  010%
//        00503  010%
//        00502  010%
//        00503  010%
//        00501  010%
//        00516  010%
//        00504  010%
//
//        Average A = 568.4
//        Average B = 505.7
//        A is faster then B - false
//
//        REVERSE:
//        StopWatch 'Test B': running time (millis) = 5052
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00508  010%
//        00505  010%
//        00500  010%
//        00498  010%
//        00498  010%
//        00510  010%
//        00516  010%
//        00509  010%
//        00508  010%
//        00500  010%
//
//        StopWatch 'Test A': running time (millis) = 5434
//        -----------------------------------------
//        ms     %     Task name
//        -----------------------------------------
//        00541  010%
//        00535  010%
//        00535  010%
//        00546  010%
//        00564  010%
//        00537  010%
//        00534  010%
//        00560  010%
//        00536  010%
//        00546  010%
//
//        Reverse Average A = 543.4
//        Reverse Average B = 505.2
//        Reverse A is faster then B - false
//        Cleanup
//        7.7918734073870356E18
//        7791873407387035632
//
//        Process finished with exit code 0
