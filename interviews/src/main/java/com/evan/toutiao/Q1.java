package com.evan.toutiao;

import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-09 10:01
 **/
public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] freq = new int[256];

        int l = 0, r = -1;
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)] = 1;
            } else {
                freq[s.charAt(l++)] = 0;
            }
            res = Math.max(res, r - l + 1);
        }
        System.out.println(res);


    }
}
