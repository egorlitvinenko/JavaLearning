package org.egor.certification.oca.strings;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * Created by Egor Litvinenko on 04.02.17.
 */
public class TestStreamTokenizer {

    public static void main(String[] args) {
        String str = "a,b,c,d,1";
        StringReader sr = new StringReader(str);
        StreamTokenizer streamTokenizer = new StreamTokenizer(sr);

        for (int i = 0; i < str.length(); ++i) {
            if (Character.isAlphabetic(str.charAt(i))) {
                streamTokenizer.ordinaryChars(i, i + 1);
            } else {
                streamTokenizer.whitespaceChars(i, i + 1);
            }
        }

        try {
            int nextToken = streamTokenizer.nextToken();
            while (nextToken != StreamTokenizer.TT_EOF) {
                System.out.println("nval = " + streamTokenizer.nval);
                System.out.println("sval = " + streamTokenizer.sval);
                System.out.println("ttype = " + streamTokenizer.ttype);
                System.out.println("ttype = " + (streamTokenizer.ttype == StreamTokenizer.TT_WORD ? "word" : "noword"));
                System.out.println("toStr = " + streamTokenizer.toString());
                System.out.println();
                nextToken = streamTokenizer.nextToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
