package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.CollisionPointer;
import org.junit.Test;

/**
 * @author jiapeng.liu
 * @date 2018/8/2 9:36
 **/
@CollisionPointer
public class Q125ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (notLetterAndDigest(left,s)){
                left++;
            }else if (notLetterAndDigest(right,s)){
                right--;
            }else if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }



    private boolean notLetterAndDigest(int index, String s) {
        return !(Character.isLetter(s.charAt(index)) || Character.isDigit(s.charAt(index)));
    }


    @Test
    public void test(){
        String s="race a car";
        System.out.println(isPalindrome(s));
    }

}
