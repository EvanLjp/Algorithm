package LEETCODE.Recursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/13.
 */
public class SurroundedRegions_130 {
    int x, y;
    boolean[][] visisted;
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        x = board.length;
        if (x != 0) y = board[0].length;
        visisted = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            if (i == 0 || i == x - 1) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] == 'O' && !visisted[i][j]) dfs(board, i, j);
                }
            } else {
                if (board[i][0] == 'O' && !visisted[i][0]) dfs(board, i, 0);
                if (board[i][y - 1] == 'O' && !visisted[i][y - 1]) dfs(board, i, y - 1);
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visisted[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private boolean isContained(int inputX, int inputY) {
        if (inputX > -1 && inputX < x && inputY > -1 && inputY < y) return true;
        else return false;
    }

    private void dfs(char[][] board, int x, int y) {
        visisted[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (isContained(newX, newY) && !visisted[newX][newY] && board[newX][newY] == 'O')
                dfs(board, newX, newY);
        }
    }

    @Test
    public void test() {
        char[][] arr = {{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}, {'X', 'X', 'X', 'O'}, {'O', 'X', 'O', 'X'}};
        solve(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
