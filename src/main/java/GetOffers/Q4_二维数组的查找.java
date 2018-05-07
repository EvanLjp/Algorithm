package GetOffers;

import org.junit.Test;

/**
 * Created by asus on 2018/3/20.
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序
 * 排序，每一列都按照从上到下递增的顺序排序。请完成一个函
 * 数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */


public class Q4_二维数组的查找 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) return false;
        return search(target, array, 0, array[0].length - 1);
    }

    private boolean search(int target, int[][] arr, int row, int col) {
        if(col<0||row==arr.length) return false;
        if (arr[row][col] == target) return true;
        else if (arr[row][col] > target) return search(target, arr, row, col - 1);
        else return search(target, arr, row + 1, col);
    }

    @Test
    public void test(){
        int[][]arr={{1,2,8,9},
                    {2,4,9,12},
                    {4,7,10,13},
                    {6,8,11,15}};

        System.out.println(Find(7,arr));

    }



}
