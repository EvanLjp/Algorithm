package LEETCODE.ARRAY;

/**
 * Created by asus on 2017/12/31.
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                    nums[flag++] = nums[i];
            }
        }
        return flag;
    }


}
