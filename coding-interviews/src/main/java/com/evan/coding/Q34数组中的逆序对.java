package com.evan.coding;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author :evan
 * @date :2018-08-21 15:52
 **/
public class Q34数组中的逆序对 {

    private long cnt=0;
    private int[] tmp;
    public int InversePairs(int [] array) {
        tmp=new int[array.length];
        mergeSort(array,0,array.length-1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] array, int l, int h) {
        if(h-l<1) return;
        int m=l+(h-l)/2;
        mergeSort(array,l,m);
        mergeSort(array,m+1,h);
        merge(array,l,m,h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i=l,j=m+1,k=l;
        while (i<=m||j<=h){
            if(i>m)
                tmp[k]=nums[j++];
            else if(j>h)
                tmp[k] = nums[i++];
            else if(nums[i]<=nums[j])
                tmp[k]=nums[i++];
            else {
                tmp[k]=nums[j++];
                this.cnt+=m-i+1;
            }
            k++;
        }
        for (int n = l; n <= h; n++) {
            nums[n]=tmp[n];
        }
    }


}
