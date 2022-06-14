package com.zsp.leetcode;

/**
 * @description:
 * @author: created by zsp on 2022/6/9 0009 16:45
 */
public class FindNum {

    /**
     * @description: 在有序数组查找一个数（二分）
     * @author: zsp
     * @date: 2022/6/9 0009 16:46
     */
    private static int findNum(int[] arr, int num) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = (endIndex + startIndex) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }
        return -1;
    }

    /**
     * @description: 找到有序数组最左的num
     * @author: zsp
     * @date: 2022/6/9 0009 17:28
     */
    private static int findLeftNum(int[] arr, int num) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int temp = -1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (arr[mid] >= num) {
                temp = mid;
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return temp;
    }

    /**
     * @description: 找到有序数组最右的num
     * @author: zsp
     * @date: 2022/6/9 0009 17:28
     */
    private static int findRightNum(int[] arr, int num) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int temp = -1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (arr[mid] > num) {
                endIndex = mid - 1;
            } else {
                temp = mid;
                startIndex = mid + 1;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8};
        System.out.println(findLeftNum(arr, 5));
        System.out.println(findRightNum(arr, 5));
    }
}
