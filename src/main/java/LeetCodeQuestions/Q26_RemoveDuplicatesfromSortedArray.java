package LeetCodeQuestions;

/**
 * Created by asus on 2018/4/15.
 */
public class Q26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[index]){
                index++;
                nums[index]=nums[i];

            }
        }
        return index+1;
    }


}
