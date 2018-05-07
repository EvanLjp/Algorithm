package LEETCODE.ARRAY;

/**
 * Created by asus on 2017/12/31.
 */
public class RemoveDuplicatesfromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[flag - 1]) {
                nums[flag] = nums[i];
                flag++;
            }
        }
        return flag;

    }


}
