package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.SlidingWindow;
import org.junit.Test;

/**
 * @author jiapeng.liu
 * @date 2018/8/3 9:27
 **/
@SlidingWindow
public class Q3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int []freq=new int[256];
        //[l,r]
        int l=0,r=-1;
        int res=0;
        while (l<s.length()){
            if (r+1<s.length()&&freq[s.charAt(r+1)]==0){
                freq[s.charAt(++r)]=1;
            }else {
                freq[s.charAt(l++)]=0;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }


    @Test
    public void test(){
        String a="abcabcbb";
        System.out.println(lengthOfLongestSubstring(a));
    }


}
