package org.egorlitvinenko.certification.oca.classes.inheritance;

import org.egorlitvinenko.certification.oca.classes.inheritance.test1.A;
import org.egorlitvinenko.certification.oca.classes.inheritance.test2.C;

import java.lang.reflect.Method;

/**
 * @author Egor Litvinenko
 */
public class TestOverriding {

    public static void main(String[] args) throws Exception {
        A a = new C();
        Method method = a.getClass().getMethod("method");
        method.invoke(a);

        a = new A();
        method = a.getClass().getMethod("method");
        method.invoke(a);
    }

}
