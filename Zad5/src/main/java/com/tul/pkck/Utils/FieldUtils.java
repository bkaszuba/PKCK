package com.tul.pkck.Utils;

public class FieldUtils {
    public static Boolean checkSilnik(String silnik) {
        String pattern = "[0-9][.][0-9]";
        return silnik.matches(pattern);
    }
}
