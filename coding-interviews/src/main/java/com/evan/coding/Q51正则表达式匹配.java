package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;
import org.junit.Test;

/**
 * @author :evan
 * @date :2018-08-22 11:37
 **/
public class Q51正则表达式匹配 {

    public boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pattern.length; i++) {
            if (pattern[i-1] != '*') {
                continue;
            } else {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= str.length; i++) {
            for (int j = 1; j <= pattern.length; j++) {
                if (pattern[j - 1] == str[i - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2]||dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }


            }
        }
        return dp[str.length][pattern.length];

    }

    @Test
    public void test(){

    }
}
