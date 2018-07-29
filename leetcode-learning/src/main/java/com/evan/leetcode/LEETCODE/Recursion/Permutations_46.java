package com.evan.leetcode.LEETCODE.Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/10.
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        getRes(res, nums, flag, 0, new LinkedList<>());
        return res;
    }

    private void getRes(List<List<Integer>> res, int[] nums, boolean[] flag, int index, List<Integer> temp) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            flag[i] = true;
            temp.add(nums[i]);
            getRes(res, nums, flag, index + 1, temp);
            flag[i] = false;
            temp.remove(temp.size() - 1);
        }
    }


}
