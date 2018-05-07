package LEETCODE.DynamicPrograming;

import org.junit.Test;

/**
 * Created by asus on 2018/2/17.
 */
public class DecodeWays_91 {


    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) return 0;
        int[] arr = new int[length + 1];
        arr[0] = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i <= length; i++) {
            if (chars[i - 1] != '0') arr[i] += arr[i - 1];
            if (i>=2&&chars[i - 2] != '0' && (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0') <= 26)
                arr[i] += arr[i - 2];
        }
        return arr[length];
    }

    @Test
    public void test(){
        System.out.println(numDecodings("0"));
    }

}
