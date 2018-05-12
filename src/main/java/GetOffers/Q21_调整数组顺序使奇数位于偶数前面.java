package GetOffers;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 12:26
 */
public class Q21_调整数组顺序使奇数位于偶数前面 {

    /**
     * 调整数组顺序使奇数位于偶数前面
     * 对撞指针思想
     * @param nums
     */
    public void reOrderArray_2(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while (start<end){
            while ((nums[start]&1)==1) start++;
            while ((nums[end]&1)==0) end--;
            if(start<end){
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
            }
        }
    }

    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int val : nums)
            if (val % 2 == 1)
                oddCnt++;
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
    }



    @Test
    public void test(){
        int[] nums= new int[]{1, 3, 2, 3, 23521, 32, 3, 2, 2, 2, 1};
        reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }






}
