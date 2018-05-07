package LEETCODE.SELECT;

import java.util.HashMap;

/**
 * Created by asus on 2018/1/14.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null){
                return true;
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }


}
