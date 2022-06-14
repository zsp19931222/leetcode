package com.zsp.leetcode;

import java.util.Arrays;

/**
 * @description: 排序
 * @author: created by zsp on 2022/6/8 0008 15:56
 */
public class Sort {


    public static void main(String[] args) {
        int[] arr = {8, 9, 77, 25, 1, 36, 5};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j;
                }
                swap(arr, minValueIndex, i);
            }
        }
    }

    private static void bubble(int[] arr) {
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second] < arr[second - 1]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    private static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentIndex = i;
            while (currentIndex - 1 >= 0 && arr[currentIndex - 1] > arr[currentIndex]) {
                swap(arr, currentIndex - 1, currentIndex);
                currentIndex--;
            }
        }
    }


    private static void swap(int[] arr, int l, int r) {
        System.out.println(Arrays.toString(arr));
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------");
    }
}
