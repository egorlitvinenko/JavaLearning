package org.egorlitvinenko.benchmark;

import org.springframework.util.StopWatch;

/**
 * @author Egor Litvinenko
 */
public abstract class AbstractABTest {

    protected void setup() {

    }

    protected void measure(boolean forceJvm, boolean reverse) {
        if (forceJvm) {
            System.out.println("Force JVM...");
        }
        final StopWatch watchA, watchB;
        if (reverse) {
            if (!forceJvm) {
                System.out.println("REVERSE:");
            }
            watchB = measureB(forceJvm);
            watchA = measureA(forceJvm);
        } else {
            if (!forceJvm) {
                System.out.println("DIRECT:");
            }
            watchA = measureA(forceJvm);
            watchB = measureB(forceJvm);
        }
        if (!forceJvm) {
            System.out.println("A stat:");
            Utils.printStatistic(watchA);
            System.out.println("B stat:");
            Utils.printStatistic(watchB);
            double averageA = (watchA.getTotalTimeMillis() / (watchA.getTaskCount() + 0.)),
                    averageB = (watchB.getTotalTimeMillis() / (watchB.getTaskCount() + 0.));
            System.out.println((reverse ? "Reverse " : "") + "A is faster then B - " + (averageA < averageB));
        }
    }

    protected StopWatch measureA(boolean forceJvm) {
        StopWatch watchA = new StopWatch("Test A");
        for (int i = 0; i < testCount(); ++i) {
            watchA.start("A - " + (i + 1));
            doA();
            watchA.stop();
        }
        if (!forceJvm) {
            System.out.println(watchA.prettyPrint());
        }
        return watchA;
    }

    protected StopWatch measureB(boolean forceJvm) {
        StopWatch watchB = new StopWatch("Test B");
        for (int i = 0; i < testCount(); ++i) {
            watchB.start("B - " + (i + 1));
            doB();
            watchB.stop();
        }
        if (!forceJvm) {
            System.out.println(watchB.prettyPrint());
        }
        return watchB;
    }


    public void doTest() {
        setup();
        measure(true, false);
        measure(true, true);
        cleanup();
        System.out.println();
        setup();
        measure(false, false);
        System.out.println();
        measure(false, true);
        cleanup();
    }

    protected abstract void doA();

    protected abstract void doB();

    protected void cleanup() {

    }

    protected int testCount() {
        return 10;
    }
}
