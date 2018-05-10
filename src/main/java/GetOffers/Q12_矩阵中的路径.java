package GetOffers;

import org.junit.Test;

/**
 * Created by asus on 2018/4/8.
 */
public class Q12_矩阵中的路径 {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private char[] str;
    private int rows, cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.str = str;
        this.rows = rows;
        this.cols = cols;
        boolean[][] map = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchRes(map, matrix, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;


    }

    private boolean searchRes(boolean[][] map, char[] matrix, int row, int col, int strPostion) {
        if(strPostion==str.length) return true;
        if (row >= rows||row<0 || col >= cols ||col<0|| map[row][col]) return false;
        int position = row * cols + col;
        if (matrix[position] != str[strPostion]) {
            return false;
        } else {
            map[row][col] = true;
            for (int j = 0; j < 4; j++) {
                if (searchRes(map, matrix, row + directions[j][0], col + directions[j][1], strPostion + 1)) {
                    return true;
                }
            }
            map[row][col] = false;
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));
    }
}
