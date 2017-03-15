package org.egor.certification.oca.classes.inheritance.test1;

import java.io.IOException;

/**
 * @author Egor Litvinenko
 */
public class B extends A {

    @Override
    protected Long method() throws IOException {
        try {
            super.method();
        } catch (Exception e) {
            throw new IOException(e);
        }
        System.out.println("B");
        return 1l;
    }

}
