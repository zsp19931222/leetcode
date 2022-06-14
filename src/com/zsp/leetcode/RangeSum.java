package com.zsp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 给定数组求i-n的和
 * @author: created by zsp on 2022/6/9 0009 11:50
 */
public class RangeSum {
    static int[] old = {8, 3, 6, -9, 8, 10, 35, -8};
    static int[] help = new int[old.length];

    public static void main(String[] args) {
        helpArray();
        System.out.println(Arrays.toString(help));
        System.out.println(sum(0,2));
    }

    private static int sum(int startIndex, int endIndex) {
        int num;
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == 0) {
            num = help[endIndex];
        } else {
            num = help[endIndex] - help[startIndex - 1];
        }
        return num;
    }

    private static void helpArray() {
        help[0] = old[0];
        for (int i = 1; i < old.length; i++) {
            help[i] = help[i - 1] + old[i];
        }
    }

}
