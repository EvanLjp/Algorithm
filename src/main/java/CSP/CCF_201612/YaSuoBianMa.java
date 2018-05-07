package CSP.CCF_201612;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by asus on 2018/3/11.
 */
public class YaSuoBianMa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        int[] datas = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            datas[i] = scanner.nextInt();
        }
        System.out.println(minCost2(datas));
    }

    private static int minCost2(int[] datas) {
        int n = datas.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n];
        int [][]p=new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i] = (i > 0 ? sum[i - 1] : 0) + datas[i];
            Arrays.fill(dp[i], 10001);
            dp[i][i] = 0;
            p[i][i]=i;
        }
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left <= n - i; left++) {
                int right = left + i - 1;
                int sumT = sum[right] - (left > 0 ? sum[left - 1] : 0);
                for (int l = p[left][right-1]; l <= p[left+1][right]; l++) {
                    if(dp[left][l] + dp[l + 1][right] + sumT<dp[left][right]){
                        dp[left][right]=dp[left][l] + dp[l + 1][right] + sumT;
                        p[left][right]=l;
                    }

                }
            }

        }


        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[0].length; j++) {
                System.out.print(p[i][j]+" ");
            }
            System.out.println();
        }
        return dp[0][n - 1];


    }

    private static int minCost(int[] datas) {
        int n = datas.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = (i > 0 ? sum[i - 1] : 0) + datas[i];
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left <= n - i; left++) {
                int right = left + i - 1;
                int sumT = sum[right] - (left > 0 ? sum[left - 1] : 0);
                for (int l = left; l < right; l++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][l] + dp[l + 1][right] + sumT);
                }
            }

        }
        return dp[0][n - 1];
    }


}
