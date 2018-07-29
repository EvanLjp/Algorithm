package com.evan.leetcode.LEETCODE.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/11.
 */
public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        getRes(res, 0, new LinkedList<>(), nums);
        return res;
    }

    private void getRes(List<List<Integer>> res, int index, LinkedList<Integer> temp, int[] nums) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (index != i && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            getRes(res, i + 1, temp, nums);
            temp.remove(temp.size() - 1);
        }

    }
    @Test
    public void test(){
        int []arr={1,2,2};
        System.out.println(subsetsWithDup(arr));
    }


}
