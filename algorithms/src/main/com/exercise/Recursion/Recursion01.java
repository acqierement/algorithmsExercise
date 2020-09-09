package com.exercise.Recursion;

public class Recursion01 {
    public static int fibonacci_2(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci_2(n - 1) + fibonacci_2(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci_2(5));//5
    }
}
