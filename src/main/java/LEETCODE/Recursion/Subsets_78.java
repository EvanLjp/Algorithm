package LEETCODE.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/11.
 */
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        getRes(res,nums,0,new LinkedList<>());
        return res;
    }

    private void getRes(List<List<Integer>> res, int[] nums,int index,List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i <nums.length ; i++) {
            temp.add(nums[i]);
            getRes(res,nums,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }

    @Test
    public void test(){
        int[] arr={1,2,3};
        System.out.println(subsets(arr));
    }

}
