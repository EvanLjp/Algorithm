package LEETCODE.ARRAY;

/**
 * Created by asus on 2018/1/7.
 */
public class LongestSubstringWithoutRepeatingCharacters_3{


    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = 0;
        int[] flag = new int[256];
        int maxLen = 0;
        while (leftIndex < chars.length) {
            if (rightIndex < chars.length && flag[chars[rightIndex]] == 0) {
                flag[chars[rightIndex++]]++;
            } else {
                flag[chars[leftIndex++]]--;
            }
            maxLen = rightIndex - leftIndex > maxLen ? rightIndex - leftIndex : maxLen;
        }
        return maxLen;
    }
}
