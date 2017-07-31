package org.egorlitvinenko.certification.oca;

import java.net.URI;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        System.out.println(Paths.get("0/123.csv").getParent().resolve("456.parquet"));
    }
}
