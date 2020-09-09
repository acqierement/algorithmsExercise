package com.exercise.String;

public class String03 {
    public int myAtoi(String str) {
        int total = 0;
        int index = 0;
        int sign = 1;
        if (str.length() == 0) return 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index >= str.length()) return 0;
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        while (index < str.length() && str.charAt(index) <= '9' && str.charAt(index) >= '0') {
            int digit = str.charAt(index) - '0';
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }

        return sign * total;
    }
}

