package LEETCODE.DynamicPrograming;

/**
 * Created by asus on 2018/2/18.
 */
public class HouseRobber_198 {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length==0) return 0;
        int[] map=new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <=i ; j++) {
                map[i]=Math.max(map[i],nums[j]+(j-2>=0?map[j-2]:0));
            }
        }
        return map[length-1];
    }
}
