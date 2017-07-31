package org.egorlitvinenko.benchmark.io;

import org.egorlitvinenko.benchmark.AbstractATest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Egor Litvinenko
 */
public class ReadFileWithOneColumnAndParseDouble extends AbstractATest {

    private String fileName = "/home/egor/Work/Nitka/r_with_cpp/TestCsv/data/test_1_000_000.csv";
    private volatile int readLines = 0;

    @Override
    protected void doA() {
        List<Double> doubles = new ArrayList<>();
        try {
            Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8).stream()
                    .forEach(line -> {
                        try {
                            doubles.add(Double.valueOf(line.replace("\"", "")));
                        } catch (NumberFormatException e) {
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        readLines = doubles.size();
    }

    @Override
    protected int testCount() {
        return 10;
    }

    @Override
    protected void cleanup() {
        System.out.println("Read " + readLines + " lines.");
    }

    public static void main(String[] args) {
        new ReadFileWithOneColumnAndParseDouble().doTest();
    }

}
