package com.evan.leetcode.algorithm.DynamicPrograming;

import org.junit.Test;

/**
 * Created by asus on 2018/2/21.
 */
public class Q474OnesandZeroes {
    private int[][] map ;
    private boolean[] strMap;
    public int[] count(String str) {
        int[] cost = new int[2];
        for (int i = 0; i < str.length(); i++)
            cost[str.charAt(i) - '0']++;
        return cost;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        strMap=new boolean[strs.length];
        map=new int[m+1][n+1];
        return getRes(strs,m,n,0);
    }

    private int getRes(String[] strs, int m, int n, int number) {

        int maxNumber=0;
        int length=strs.length;
        if(m==0&&n==0) return number;
        for (int i = 0; i < length; i++) {
            if(strMap[i]) continue;
            int[] count = count(strs[i]);
            if(count[0]>m||count[1]>n) continue;
            maxNumber= Math.max(maxNumber,number+1);
            strMap[i]=true;
            maxNumber=Math.max(maxNumber,getRes(strs,m-count[0],n-count[1],number+1));
            strMap[i]=false;
        }
        map[m][n]=Math.max(map[m][n],maxNumber);
        return map[m][n];
    }

    /**
     * 仅仅此版本为正确版本
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm_2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] cost = count(s);
            for (int i = m; i >= cost[0]; i--)
                for (int j = n; j >= cost[1]; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - cost[0]][j - cost[1]] + 1);
                    printArr(dp);
                }

        }
        return dp[m][n];
    }

    void  printArr(int[][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("<br>");
        }
        System.out.println("============================<br>");
    }


    @Test
    public void test(){
        String[]arr={"10","0001","111001","1","0"};
       /* //String[]arr={"011","1","11","0","010","1","10","1","1","0","0","0"
                ,"01111","011","11","00","11","10","1","0","0",
                "0","0","101","001110","1","0","1","0","0","10",
                "00100","0","10","1","1","1","011","11","11","10",
                "10","0000","01","1","10","0"};*/
        System.out.println(findMaxForm_2(arr,5,3));
    }

}
