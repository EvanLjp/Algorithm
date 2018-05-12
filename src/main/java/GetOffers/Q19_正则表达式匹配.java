package GetOffers;

import org.junit.Test;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 10:14
 */
public class Q19_正则表达式匹配 {
    public boolean match(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pattern[i - 1] == '*') dp[0][i] = dp[0][i - 2];//初始化,比如b*与""也匹配,于是设置为true
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];//字符匹配,就和pattern截至到前一个的情况与字符截至前一个情况相同
                else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        //可能匹配一个,0个或者n个
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        //a和b*的b不匹配所以匹配0个
                        dp[i][j] = dp[i][j - 2];
                    }
                }

            }

        }
        return dp[m][n];
    }

    @Test
    public void test(){
        match(new char[]{}, new char[]{'.', '*'});
    }

}
