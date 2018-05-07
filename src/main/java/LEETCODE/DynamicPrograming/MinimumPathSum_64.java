package LEETCODE.DynamicPrograming;


import org.junit.Test;

/**
 * Created by asus on 2018/2/17.
 */
public class MinimumPathSum_64 {

    private int getMin(int a, int b) {
        if (a == -1 && b == -1) return 0;
        else if (a == -1) return b;
        else if (b == -1) return a;
        else return a < b ? a : b;
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] temp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i == 0 || j == 0) temp[i][j] = -1;
                else temp[i][j] = grid[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                temp[i][j] += getMin(temp[i - 1][j], temp[i][j - 1]);
            }
        }
        return temp[row][col];
    }

    private void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=============================================");
    }

    @Test
    public void test() {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(arr));
    }


}
