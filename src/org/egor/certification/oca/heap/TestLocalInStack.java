package org.egor.certification.oca.heap;

/**
 * To see bytecode
 *
 * @author Egor Litvinenko
 */
public class TestLocalInStack {

    int c;

    TestLocalInStack() {
        c = 3;
    }

    public static void method1(int b) {
        int a = 1;
        TestLocalInStack d = new TestLocalInStack();
        System.out.println(a);
        System.out.println(b);
        System.out.println(d.c);
    }

    public static void main(String[] args) {
        TestLocalInStack.method1(2);
    }


}
