package GetOffers;

import org.junit.Test;

/**
 * Created by asus on 2018/4/8.
 */
public class 机器人的运动范围 {
    private int rows, cols;
    private  int count = 0;
    int[][] map = {{-1, -0}, {1, 0}, {0, -1}, {0, 1}};

    public int movingCount(int threshold, int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        boolean[][] vis = new boolean[rows][cols];
        moveStep(vis, threshold, 0, 0);

        return count;
    }

    private void moveStep(boolean[][] vis, int threshold, int row, int col) {
        if(row<0||col<0||row>=rows||col>=cols||vis[row][col] || !checkNum(row, col, threshold)) return;
        vis[row][col] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            moveStep(vis, threshold, row + map[i][0], col + map[i][1]);
        }

    }

    private boolean checkNum(int row, int col, int threshold) {

        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col != 0) {
            sum += col % 10;
            col /= 10;
        }
        if (sum > threshold) return false;
        else return true;
    }

    @Test
    public void test(){
        System.out.println(movingCount(10,1,100));
    }

}
