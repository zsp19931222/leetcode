package com.zsp.leetcode;

/**
 * @description: N的阶乘
 * @author: created by zsp on 2022/6/8 0008 14:45
 */
public class Factorial {
    public static void main(String[] args) {
        factorial(9);
    }

    private static void factorial(int n) {
        long result = 0;
        long temp = 1;
        for (int i = 1; i <= n; i++) {
            temp = temp * i;
            result+=temp;
        }
        System.out.println(result);
    }
}
