package LEETCODE.ARRAY;

/**
 * Created by asus on 2017/12/31.
 */
public class SortColors_75 {


    public void sortColors(int[] nums) {
        int n= nums.length;
        int zero=-1;//[0,zero]
        int two=n; //[two,num.length-1]

        for (int i = 0; i < two ; ) {
            if(nums[i]==1){
                i++;
            }else if(nums[i]==0){
                swap(nums,++zero,i++);
            }else {
                swap(nums,i,--two);
            }
        }


    }

    public void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }


}
