package org.egorlitvinenko.certification.oca.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Egor Litvinenko
 */
public class CreateDirectories {

    public void createDirectories(String path) {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new CreateDirectories().createDirectories("/home/egor/democritus_data/test/see/my/rights");
    }

}
