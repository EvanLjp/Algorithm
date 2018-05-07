package LEETCODE.ALL;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/2/27.
 */
public class L1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) return new int[]{map.get(nums[i]),i};
            else{
                map.put(target-nums[i],i);
            }
        }
        return new int[]{};
    }

}
