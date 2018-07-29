package com.evan.interviews;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 22:12
 */
public class Q47_礼物的最大价值 {
    public int getMost(int[][] board) {
        if (board.length == 0) return 0;
        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i - 1][j - 1];
            }
        }
        return dp[rows][cols];
    }


}
