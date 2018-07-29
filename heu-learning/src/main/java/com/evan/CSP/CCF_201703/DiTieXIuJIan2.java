package com.evan.CSP.CCF_201703;


import java.util.Scanner;

/**
 * Created by asus on 2018/3/9.
 */
public class DiTieXIuJIan2 {


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int numbers = scanner.nextInt();
        int lines = scanner.nextInt();
        int[][] graph=new int[numbers+1][numbers+1];
        int[][] res=new int[numbers+1][numbers+1];
        for (int i = 0; i <lines ; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int day = scanner.nextInt();
            graph[from][to]=day;
            graph[to][from]=day;
        }

        for (int i = 1; i <= numbers; i++) {
            for (int j = 1; j <= numbers; j++) {
                if(graph[i][j]==0){
                    res[i][j]=res[i-1][j];
                    continue;
                }
                res[i][j] = res[i-1][j]==0?graph[i][j]:Math.min(graph[i][j], res[i - 1][j]);

            }
        }
        System.out.println(res[numbers][numbers]);
    }




}
