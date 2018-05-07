package LEETCODE.Recursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/12.
 */
public class WordSearch_79 {
    private int x;
    private int y;
    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] map;

    public boolean exist(char[][] board, String word) {
        x = board.length;
        y = board[0].length;
        map = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (isValid(board, word, 0, i, j)) return true;
            }
        }
        return false;

    }

    private boolean isContained(int inputX, int inputY) {
        if (inputX > -1 && inputX < x && inputY > -1 && inputY < y) return true;
        else return false;
    }

    private boolean isValid(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1) return word.charAt(index) == board[x][y];
        if (board[x][y] == word.charAt(index)) {
            map[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (isContained(newX, newY) && !map[newX][newY]
                        && isValid(board, word, index + 1, newX, newY)) return true;
            }
            map[x][y] = false;
        }
        return false;
    }

    @Test
    public void test() {
        char[][] map = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(map, "ABCCED"));
    }

}
