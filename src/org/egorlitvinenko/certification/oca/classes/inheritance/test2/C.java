package org.egorlitvinenko.certification.oca.classes.inheritance.test2;

import org.egorlitvinenko.certification.oca.classes.inheritance.test1.B;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Egor Litvinenko
 */
public class C extends B {

    @Override
    public Long method() throws FileNotFoundException {
        try {
            super.method();
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        System.out.println("C");
        return 2l;
    }
}
