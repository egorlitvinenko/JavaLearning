package org.egorlitvinenko.certification.oca.book1.chapter2;

/**
 * Created by Egor Litvinenko on 04.02.17.
 */
public class OperatorPrecedence {

    public static void main(String[] args) {
        precendenceTable();
        testModulus();
        threePlusOrMinus();
        bitwiseComplement();
    }

    static void bitwiseComplement() {
        System.out.println("bitwiseComplement");
        System.out.println(~1);
        System.out.println(~2);
        System.out.println(~-1);
        System.out.println(~0);
        System.out.println(~-0);
        System.out.println(~-20);
    }

    static void precendenceTable() {
        System.out.println("precendenceTable");
        final String FORMAT = "%1$50s\t%2$35s = %3$s";
        int x = 10;
        System.out.println(String.format(FORMAT, "Post unary operators ++, --:", "x++", x++));
        System.out.println(String.format(FORMAT, "Pre unary operators ++, --:", "--x", --x));
        System.out.println(String.format(FORMAT, "Unary operators +,-,!,~:", "-x", -x));
        System.out.println(String.format(FORMAT, "Unary operators +,-,!,~:", "~x", ~x));
        System.out.println(String.format(FORMAT, "Multiplicative operators *,/,%:", "x * 2 % 3", x * 2 % 3));
        System.out.println(String.format(FORMAT, "Addition, subtraction +, -:", "(x - 2 << 1 >> 1)", (x - 2 << 1 >> 1)));
        System.out.println(String.format(FORMAT, "Shift operators >>, <<, >>>:", "(x - 2 >>> 1 >> 1)", (x - 2 >>> 1 >> 1)));
        System.out.println(String.format(FORMAT, "Relational operators <=,<,>,>=, instanceof:", "IntegerX + 1 instanceof Integer", "CE - ") + "Inconvertible types: can not cast int to Integer");
        System.out.println(String.format(FORMAT, "Relational operators <=,<,>,>=, instanceof:", "x instanceof Integer", "CE - ") + "Inconvertible types: can not cast int to Integer");
        System.out.println(String.format(FORMAT, "Relational operators <=,<,>,>=, instanceof:", "x + 1 << 1 < 5", x + 1 << 1 < 5));
        System.out.println(String.format(FORMAT, "Equality operators ==, !=:", "x + 1 >> 1 == 5", x + 1 >> 1 == 5));
        System.out.println(String.format(FORMAT, "Logical operators &, ^, |:", "x++ ^ 1 > 5 | x & 1 != 0", "CE - operator can not be applied to int (precedence isn't correct"));
        System.out.println(String.format(FORMAT, "Logical operators &, ^, |:", "(x++ ^ 1) > 5 ^ (x & 1) != 0", (x++ ^ 1) > 5 ^ (x & 1) != 0));
        System.out.println(String.format(FORMAT, "Logical operators &, ^, |:", "(x++ ^ 1) > 5 & (x & 1) != 0", (x++ ^ 1) > 5 & (x & 1) != 0));
        System.out.println(x);
        System.out.println(String.format(FORMAT, "Short-circuit logical operators &&, ||:", "x > 5 || (x -= 20) < 0", x > 5 || (x -= 20) < 0) + ", x = " + x);
        System.out.println(String.format(FORMAT, "Ternary operators ?: :", "x > 100 ? 1 : 2 + 1", x > 5 ? 1 : 2 + 1));
        System.out.println(x);
        System.out.println(String.format(FORMAT, "Assignment operators:", "(x = 10) + (x > 10 ? 1 : 2)", (x = 10) + (x > 10 ? 1 : 2)));
        System.out.println(String.format(FORMAT, "Assignment operators:", "x = x > 10 ? 1 : 2", x = x > 10 ? 1 : 2));
        System.out.println(x);
    }

    static void testModulus() {
        System.out.println("testModulus");
        System.out.println((1 + 2 + 3 % 2 == 0) + ", " + (1 + 2 + 3 % 2));
        System.out.println(((1 + 2 + 3) % 2 == 0) + ", " + ((1 + 2 + 3) % 2));
    }

    static void threePlusOrMinus() {
        System.out.println("threePlusOrMinus");
        int a = 2;
        a = - - --a;
        System.out.println(a);
    }

}
