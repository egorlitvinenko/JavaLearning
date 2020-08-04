package org.egorlitvinenko.benchmark.io;

import org.egorlitvinenko.benchmark.AbstractATest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Egor Litvinenko
 */
public class ReadFileWithOneColumn extends AbstractATest {

    private String fileName = "/path_to/test_1_000_000.csv";
    private volatile LongHolder readLinesLength = new LongHolder();

    @Override
    protected void doA() {
        readLinesLength.sum = 0;
        try {
            Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8).stream()
                    .forEach(line -> {
                        readLinesLength.sum += line.length();
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected int testCount() {
        return 10;
    }

    @Override
    protected void cleanup() {
        System.out.println("Read lines length = " + readLinesLength.sum + ".");
    }

    public static void main(String[] args) {
        new ReadFileWithOneColumn().doTest();
    }

    private static class LongHolder {
        long sum = 0;
    }


}
