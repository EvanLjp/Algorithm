package com.evan.leetcode.LEETCODE.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/11.
 */
public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        getRes(res, 0, flag, nums, new LinkedList<>());
        return res;
    }

    private void getRes(List<List<Integer>> res, int i, boolean[] flag, int[] nums, LinkedList<Integer> temp) {

        if (i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (flag[j] || j > 0 && nums[j] == nums[j - 1] && !flag[j - 1]) continue;
            flag[j] = true;
            temp.add(nums[j]);
            getRes(res, i + 1, flag, nums, temp);
            flag[j] = false;
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test(){
        int[] arr={1,1,2};
        System.out.println(permuteUnique(arr));

    }



}
