package com.evan.leetcode.LEETCODE.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/11.
 */
public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        getRes(res, candidates, 0, target, new LinkedList<>());
        return res;
    }

    private void getRes(List<List<Integer>> res, int[] candidates, int index, int target, LinkedList<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if(i!=index&&candidates[i]==candidates[i-1]) continue;
            temp.add(candidates[i]);
            getRes(res, candidates, i + 1, target - candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test(){
        int[] arr={10,1,2,7,6,1,5};
        System.out.println(combinationSum2(arr,8));
    }


}
