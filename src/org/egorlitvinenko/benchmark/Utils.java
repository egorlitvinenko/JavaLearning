package org.egorlitvinenko.benchmark;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.springframework.util.StopWatch;

/**
 * @author Egor Litvinenko
 */
public class Utils {

    public static final String STAT_FORMAT = "%-20s: %s\n";

    public static void printStatistic(StopWatch stopWatch) {
        StopWatch.TaskInfo[] infos = stopWatch.getTaskInfo();
        SummaryStatistics summaryStatistics = new SummaryStatistics();
        for (int i = 0; i < infos.length; ++i) {
            summaryStatistics.addValue(infos[i].getTimeMillis());
        }
        System.out.printf(STAT_FORMAT, "Mean", summaryStatistics.getMean());
        System.out.printf(STAT_FORMAT, "Variance", summaryStatistics.getVariance());
        System.out.printf(STAT_FORMAT, "Standard deviation", summaryStatistics.getStandardDeviation());
        System.out.printf(STAT_FORMAT, "Min", summaryStatistics.getMin());
        System.out.printf(STAT_FORMAT, "Max", summaryStatistics.getMax());
        System.out.printf(STAT_FORMAT, "Total", summaryStatistics.getSum());
    }

    public static void main(String[] args) {
        // test
        StopWatch watch = new StopWatch();
        watch.start();
        watch.stop();
        printStatistic(watch);
    }

}
