package com.evan.coding;


import org.junit.Test;

/**
 * @author :evan
 * @date :2018-08-21 16:26
 **/
public class Q36数字在排序数组中出现的次数 {
    public int GetNumberOfK(int [] array , int k) {
        int first=binarySearch(array,k);
        int next=binarySearch(array,k+1);
        return (first==array.length||array[first]!=k)?0:next-first;
    }

    private int binarySearch(int[] nums ,int k){
        int l=0,h=nums.length;
        while (l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=k){
                h=mid;
            }else
                l=mid+1;
        }
        return l;
    }

    @Test
    public void test(){
        System.out.println(GetNumberOfK(new int[]{1,2,3,3,3,3,5},3));
    }


}
