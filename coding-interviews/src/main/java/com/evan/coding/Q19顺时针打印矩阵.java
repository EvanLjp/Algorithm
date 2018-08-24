package com.evan.coding;

import java.util.ArrayList;

/**
 * @author :evan
 * @date :2018-08-20 14:16
 **/
public class Q19顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int rowTop = 0,
                rowBottom = matrix.length - 1,
                colLeft = 0,
                colRight = matrix[0].length - 1;
        while (rowTop <= rowBottom && colLeft <= colRight) {
            for (int i = colLeft; i <= colRight; i++) {
                list.add(matrix[rowTop][i]);
            }
            rowTop++;
            if (rowTop>rowBottom){
                break;
            }
            for (int i = rowTop; i <= rowBottom; i++) {
                list.add(matrix[i][colRight]);
            }
            colRight--;
            if (colRight<colLeft){
                break;
            }
            for (int i = colRight; i >= colLeft; i--) {
                list.add(matrix[rowBottom][i]);
            }
            rowBottom--;
            if (rowTop>rowBottom){
                break;
            }
            for (int i = rowBottom; i >= rowTop; i--) {
                list.add(matrix[i][colLeft]);
            }
            colLeft++;
        }
        return list;

    }


}
