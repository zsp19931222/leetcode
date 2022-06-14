package com.zsp.leetcode;

/**
 * @description:
 * @author: created by zsp on 2022/6/8 0008 10:23
 */
public class CharacterExchange {
   static String str = "abcdef";


    public static void main(String[] args) {
        for (int i = 0; i < str.toCharArray().length/2; i++) {
           reverse(i,str.length()-(i+1));
        }
        System.out.println(str);
        printNumBinary(~2);
        System.out.println(~2);
        System.out.println(3<<1);
        int a=Integer.MIN_VALUE>>1;
        System.out.println(a);
        printNumBinary(a);
        int b=Integer.MIN_VALUE>>>1;
        System.out.println(b);
        printNumBinary(b);
        System.out.println(~Integer.MIN_VALUE);
        printNumBinary(~Integer.MIN_VALUE);
    }

    private static void reverse(int L,int R) {
        char[] chars = str.toCharArray();
        char temp = chars[L];
        chars[L] = chars[R];
        chars[R] = temp;
        System.out.println(chars);
        str=String.valueOf(chars);
    }

    private static void  printNumBinary(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print((num&(1<<i))==0?"0":"1");
        }
        System.out.println();
    }
}
