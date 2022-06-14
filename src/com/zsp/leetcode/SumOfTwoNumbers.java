package com.zsp.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: created by zsp on 2022/6/7 0007 10:46
 */
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,6,9,2};
        int target=3;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(hashMapSum(nums, target)));
        System.out.println(~8);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int result0 = target - num;
            result[0]=i;
            for (int i1 = nums.length - 1; i1 >= 0; i1--) {
                if (result0==nums[i1]){
                    result[1]=i1;
                }
            }
        }
        return result;
    }

    public static int[] hashMapSum(int[] nums, int target){
        HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>(4);
        for (int i = 0; i <nums.length ; i++) {
            int num = nums[i];
            int i1 = target - num;
            if (hashMap.containsKey(i1)){
                return new int[] {hashMap.get(i1),i};
            }
            hashMap.put(num,i);
        }
        throw new IllegalArgumentException("不存在");
    }
}
