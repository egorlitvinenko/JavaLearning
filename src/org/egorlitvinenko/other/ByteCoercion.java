package org.egorlitvinenko.other;

import java.nio.ByteBuffer;

/**
 *
 * https://docs.oracle.com/javase/specs/jls/se11/html/jls-3.html#jls-3.10.1
 * https://docs.oracle.com/javase/specs/jls/se11/html/jls-4.html#jls-4.2.1
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-2.html#jvms-2.11.1
 *
 * **/
public class ByteCoercion {

    public static void main(String[] args) {
        byte a = -83;
        int b = a;
        byte c = (byte) b;
//        int d = 0x800000CD;
        int d = 0x8000004D;
        byte e = (byte) d;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("b as binary: " + Integer.toBinaryString(b));
        System.out.println("b as bytes:"); print(intToByteArray(b));
        System.out.println("b as bytesBB:"); print(intToByteArrayBB(b));
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("d as binary: " + Integer.toBinaryString(d));
        System.out.println("d as bytes:"); print(intToByteArray(d));
        System.out.println("d as bytesBB:"); print(intToByteArrayBB(d));
    }

    private static void print(byte[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("array=(");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append(")");
        System.out.println(sb);
    }

    private static byte[] intToByteArray(int a) {
        byte[] result = new byte[4];
        result[0] = (byte) (a & 0x000000FF);
        result[1] = (byte) ((a & 0x0000FF00) >> 8);
        result[2] = (byte) ((a & 0x00FF0000) >> 16);
        result[3] = (byte) ((a & 0xFF000000) >> 24);
        return result;
    }

    private static byte[] intToByteArrayBB(int a) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(a);
        return bb.array();
    }
}
