package com.evan.贝壳;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :evan
 * @date :2018-09-03 20:53
 **/
public class Q3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();
        int [][] map=new int[number][2];
        for (int i = 0; i < number; i++) {
            map[i][0]=scanner.nextInt();
            map[i][1]=scanner.nextInt();
        }
        Arrays.sort(map,(o1, o2) -> o1[0]-o2[0]);

        for (int i = map.length-1; i >=0 ; i++) {
            if ((Math.abs(map[i-1][1]-map[i][1]))>=map[i][0]-map[i-1][0]){

            }
        }

    }


}
