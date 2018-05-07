package LeetCodeQuestions;

/**
 * Created by asus on 2018/4/15.
 */
public class Q27_RemoveElement {
    public int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i == index) index++;
                else {
                    nums[index++] = nums[i];
                }
            }
        }
        return index;
    }


}
