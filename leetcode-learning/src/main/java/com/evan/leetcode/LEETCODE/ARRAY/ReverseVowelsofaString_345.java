package com.evan.leetcode.LEETCODE.ARRAY;

/**
 * Created by asus on 2018/1/4.
 */
public class ReverseVowelsofaString_345 {
    public static String reverseVowels(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = chars.length - 1;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex&&!isVowels(chars[leftIndex])) leftIndex++;
            while (leftIndex < rightIndex&&!isVowels(chars[rightIndex])) rightIndex--;
            swap(chars, leftIndex++, rightIndex--);
        }
        return new String(chars);

    }
    private static void swap(char[] arr, int l, int r) {
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private static boolean isVowels(char c){
        if(c>='a'){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')return true;
            else return false;
        }else {
            if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')return true;
            else return false;
        }

    }

    public static void main(String[] args) {
        String ss="hello";
        System.out.println(reverseVowels(ss));
    }

}
