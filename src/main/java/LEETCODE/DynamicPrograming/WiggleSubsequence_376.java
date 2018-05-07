package LEETCODE.DynamicPrograming;

import org.junit.Test;

/**
 * Created by asus on 2018/2/23.
 */
public class WiggleSubsequence_376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n <= 1)
            return n;
        int result = nums[0] != nums[1] ? 2:1;
        int flag = nums[1] - nums[0];
        for(int i=2;i<nums.length;i++){
            if((nums[i] - nums[i-1]) * flag < 0 || (flag==0 && (nums[i] - nums[i-1])!=0)){
                result ++;
                flag = nums[i] - nums[i-1];
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[]ar={3,3,3,2,5};
        System.out.println(wiggleMaxLength(ar));
    }

}
