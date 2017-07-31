package org.egorlitvinenko.certification.oca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Egor Litvinenko
 */
public class TestRegexp {

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile(".*(\\#dimension(\\(['\"].+['\"],*+\\))).*").matcher("\"Product\" = #dimension('PS1')");
        System.out.println(matcher.matches());
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group());
    }

}
