package LEETCODE.DynamicPrograming;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/16.
 */
public class Triangle_120 {
    /**
     * 版本1,利用递归解决,代码较少但是问题是重复计算子问题
     * 递归表达式是val(i,j)=min(val(i+1,j),val(i+1,j+1))+i,j值
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        return getMin(triangle, 0, 0);

    }

    private int getMin(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) return 0;
        int val = triangle.get(row).get(col);
        int left = getMin(triangle, row + 1, col);
        int right = getMin(triangle, row + 1, col + 1);
        return val + Math.min(left, right);
    }

    /**
     * 版本2
     * 记忆搜索化
     * @param triangle
     * @return
     */
    private HashMap<String,Integer> map=new HashMap<>();
    public int minimumTotal1(List<List<Integer>> triangle) {
        return getMin(triangle, 0, 0);

    }
    private int getMin1(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) return 0;
        String key=row+":"+col;
        if(map.containsKey(key)) return map.get(key) ;
        int val = triangle.get(row).get(col);
        int left = getMin(triangle, row + 1, col);
        int right = getMin(triangle, row + 1, col + 1);
        int value =val + Math.min(left, right);
        map.put(key,value);
        return value;
    }

    /**
     * 版本3,动态规划,自底向上解决问题
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0) return 0;
        int [] minPath=new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >=0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                minPath[j]=Math.min(minPath[j],minPath[j+1])+list.get(j);
            }
        }
        return minPath[0];

    }



    List<Integer> arrayToList(int[] arr) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    @Test
    public void test() {
        List res = new LinkedList();
        res.add(arrayToList(new int[]{2}));
        res.add(arrayToList(new int[]{3, 4}));
        res.add(arrayToList(new int[]{6, 5, 7}));
        res.add(arrayToList(new int[]{4, 1, 8, 3}));
        long start = System.currentTimeMillis();
        System.out.println(minimumTotal2(res));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }


}
