package LEETCODE.Recursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/14.
 */
public class SudokuSolver_37 {
    boolean[][] rowMap, colMap, squareMap;

    public void solveSudoku(char[][] board) {
        rowMap = new boolean[9][9];
        colMap = new boolean[9][9];
        squareMap = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] - '1';
                    rowMap[i][number] = true;
                    colMap[j][number] = true;
                    squareMap[3 * (i / 3) + (j / 3)][number] = true;
                }
            }
        }
        getRes(board, 0);
    }

    private boolean isVaild(int i, int j, int number) {
        return !rowMap[i][number] && !colMap[j][number] && !squareMap[3 * (i / 3) + (j / 3)][number];
    }

    private boolean getRes(char[][] board, int index) {
        for (int a = index; a < 81; a++) {
            int i = a / 9, j = a % 9;
            if (board[i][j] != '.') {
                continue;
            }
            for (int k = 0; k < 9; k++) {
                if (isVaild(i, j, k)) {
                    board[i][j] = (char) (k + '1');
                    rowMap[i][k] = true;
                    colMap[j][k] = true;
                    squareMap[3 * (i / 3) + (j / 3)][k] = true;
                    if (getRes(board, i)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                        rowMap[i][k] = false;
                        colMap[j][k] = false;
                        squareMap[3 * (i / 3) + (j / 3)][k] = false;
                    }
                }
            }
            return false;
        }

        return true;
    }

    @Test
    public void test() {
        char[][] arr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        soutArr(arr);
        System.out.println("=================");
        solveSudoku(arr);
        soutArr(arr);
    }

    private void soutArr(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
