package GetOffers;

import java.util.Arrays;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 22:27
 */
public class Q48_最长不含重复字符的子字符串 {


    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            int preIndex = preIndexs[c];
            if (preIndex == -1 || i - preIndex > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = i - preIndex;
            }
            preIndexs[c] = i;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;




    }



}
