package com.tul.pkck.Utils;

public class FieldUtils {
    public static Boolean checkSilnik(String silnik) {
        String pattern = "[0-9][.][0-9]";
        return silnik.matches(pattern);
    }

    public static Boolean checkNumer(String numer) {
        String pattern = "[0-9]{9}";
        return numer.matches(pattern);
    }

    public static Boolean checkRocznik(String rocznik) {
        String pattern = "[0-9]{4}";
        return rocznik.matches(pattern);
    }

    public static Boolean checkOnlyDigits(String digits) {
        String pattern = "[0-9]+";
        return digits.matches(pattern);
    }

    public static Boolean checkOnlyLetterWithFirstCapital(String word) {
        String pattern = "[A-Z][a-z]+";
        return word.matches(pattern);
    }

}
