package GetOffers;

import org.junit.Test;

import java.util.Map;

/**
 * Created by asus on 2018/4/8.
 */
public class Q13_机器人的运动范围 {
    private int rows, cols;
    private  int count = 0;
    private int threshold=0;
    private int[][] digitSumMap;
    int[][] map = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int movingCount(int threshold, int rows, int cols) {
       this.rows=rows;
       this.cols=cols;
       this.threshold=threshold;
       initDigitSumMap();
       boolean[][]visited=new boolean[rows][cols];
       dfs(0,0,visited);
       return count;
    }

    private void dfs(int row, int col, boolean[][] visited) {
        if(row<0||row>=rows||col<0||col>=cols||visited[row][col]||digitSumMap[row][col]>threshold) return;
        visited[row][col]=true;
        count++;
        for (int[] n:map){
            dfs(row+n[0],col+n[1],visited);
        }
    }

    private void initDigitSumMap() {
        int[] digitSum=new int[Math.max(rows,cols)];
        for (int i = 0; i < digitSum.length; i++) {
            int num=i;
            while (num>0){
                digitSum[i]+=num%10;
                num/=10;
            }
        }
        digitSumMap=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSumMap[i][j] = digitSum[i] + digitSum[j];
            }
        }
    }


    @Test
    public void test(){
        System.out.println(movingCount(10,1,100));
    }

}
