package com.evan.leetcode.LEETCODE.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/11.
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        getRes(res, 0,candidates, target, new LinkedList<>());
        return res;
    }

    private void getRes(List<List<Integer>> res,int index, int[] candidates, int target, LinkedList<Integer> temp) {
        if (target==0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(target<candidates[i]) break;
            if(i!=index&&candidates[i]==candidates[i-1]) continue;
            temp.add(candidates[i]);
            getRes(res,i, candidates, target-candidates[i], temp);
            temp.remove(temp.size() - 1);
        }


    }


}
