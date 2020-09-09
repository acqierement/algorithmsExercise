package com.exercise.Recursion;

public class Recursion04 {

    public int climbStairsByRecursion(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return climbStairsByRecursion(n - 1) + climbStairsByRecursion(n - 2);
    }

    public int climbStairs(int n) {
        int[] res = {1,1};
        if(n < 0) throw new IllegalArgumentException("input wrong");

        if(n < 2) return res[n];

        int one_step_before = 1;
        int two_step_before = 1;
        int step_now = 2;
        for (int i = 2; i <= n; i++) {
            step_now = one_step_before + two_step_before;
            two_step_before = one_step_before;
            one_step_before = step_now;
        }
        return step_now;
    }
}
