package com.evan.interviews;

import java.util.ArrayList;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 21:27
 */
public class Q29_顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int rowTop = 0, rowBottom = matrix.length - 1, colLeft = 0, colRight = matrix[0].length - 1;

        while (rowTop <= rowBottom && colLeft <= colRight) {
            for (int i = colLeft; i <= colRight; i++) {
                res.add(matrix[rowTop][i]);
            }
            for (int i = rowTop + 1; i <= rowBottom; i++) {
                res.add(matrix[i][colRight]);
            }
            if (rowTop != rowBottom)
                for (int i = colRight - 1; i >= colLeft; i--) {
                    res.add(matrix[rowBottom][i]);
                }
            if (colLeft != colRight)
                for (int i = rowBottom - 1; i > rowTop; i--) {
                    res.add(matrix[i][colLeft]);
                }
            rowTop++;
            rowBottom--;
            colLeft++;
            colRight--;


        }
        return res;


    }


}
