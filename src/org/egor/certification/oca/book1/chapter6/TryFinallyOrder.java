package org.egor.certification.oca.book1.chapter6;

import java.io.IOException;

/**
 * @author Egor Litvinenko
 */
class TryFinallyOrder {

    public static void main(String[] args) throws Exception, OutOfMemoryError {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        } finally {
            throw new Exception();
        }
    }

}
