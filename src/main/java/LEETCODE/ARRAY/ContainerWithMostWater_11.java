package LEETCODE.ARRAY;

import org.junit.Test;

/**
 * Created by asus on 2018/1/5.
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int leftIndex=0;
        int rightIndex=height.length-1;
        int maxArea=0;
        while (leftIndex<rightIndex){
            int minIndex=height[leftIndex]<height[rightIndex]?leftIndex:rightIndex;
            int temp=(rightIndex-leftIndex)*height[minIndex];
            maxArea=temp>maxArea?temp:maxArea;
            if(minIndex==leftIndex){
                while (leftIndex<rightIndex&&height[leftIndex]<=height[minIndex]) leftIndex++;
            }else {
                while (leftIndex<rightIndex&&height[rightIndex]<=height[minIndex]) rightIndex--;
            }
        }
        return maxArea;
    }


    @Test
    public void test(){
        int[] h={1,2,4,3};
        System.out.println(maxArea(h));
    }

}
