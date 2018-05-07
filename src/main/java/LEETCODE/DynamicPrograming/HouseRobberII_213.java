package LEETCODE.DynamicPrograming;

import org.junit.Test;

/**
 * Created by asus on 2018/2/18.
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length==0) return 0;
        if(length==1) return nums[0];
        int[] map1=new int[length-1];
        int[] map2=new int[length-1];
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j <=i; j++) {
                map1[i]= Math.max(map1[i],nums[j]+(j>=2?map1[j-2]:0));
                map2[i]= Math.max(map2[i],nums[j+1]+(j>=2?map2[j-2]:0));
            }
        }
        return Math.max(map1[length-2],map2[length-2]);

    }
    @Test
    public void test(){
        int[] arr={1,1,1,1};
        System.out.println(rob(arr));
    }


}
