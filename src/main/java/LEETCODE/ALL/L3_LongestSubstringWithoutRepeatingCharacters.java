package LEETCODE.ALL;

/**
 * Created by asus on 2018/3/1.
 */
public class L3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int[] arr=new int[256];
        int max=0;
        int temp=0;
        for (int i = 0; i < length; i++) {
            arr[s.charAt(i)]=1;
            for (int j = i;arr[s.charAt(j)]!=1 ; j++) {
                temp++;
            }
            arr[s.charAt(i)]=0;
            max=Math.max(temp,max);
        }
        return max;

    }



}
