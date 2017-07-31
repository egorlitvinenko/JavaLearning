package org.egorlitvinenko.benchmark;

import org.springframework.util.StopWatch;

/**
 * @author Egor Litvinenko
 */
public abstract class AbstractATest {

    protected void setup() {

    }

    protected void measure(boolean forceJvm) {
        if (forceJvm) {
            System.out.println("Force JVM...");
        }
        final StopWatch watchA;
        if (!forceJvm) {
            System.out.println("DIRECT:");
        }
        watchA = measureA(forceJvm);
        if (!forceJvm) {
            Utils.printStatistic(watchA);
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

    public void doTest() {
        System.out.println("Setup...");
        setup();
        measure(true);
        System.out.println("Cleanup...");
        cleanup();
        System.out.println();
        System.out.println("Setup...");
        setup();
        measure(false);
        System.out.println();
        System.out.println("Cleanup...");
        cleanup();
    }

    protected abstract void doA();

    protected void cleanup() {

    }

    protected int testCount() {
        return 10;
    }

}
