package org.egorlitvinenko.certification.oca.book1.chapter4;

/**
 * @author Egor Litvinenko
 */
public class Q15 {

    public void print(byte a) {
        System.out.print("byte");
    }

    public void print(int a) {
        System.out.print("int");
    }

    public void print(float a) {
        System.out.print("float");
    }

    public void print(Object a) {
        System.out.print("Object");
    }

    public static void main(String[] args) {
        Q15 q15 = new Q15();
        short a = 123;
        q15.print(a);
        q15.print(true);
        q15.print(6.2);
    }


}
