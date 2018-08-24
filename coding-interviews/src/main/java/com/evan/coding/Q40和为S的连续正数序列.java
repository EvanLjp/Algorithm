package com.evan.coding;

import org.junit.Test;
import org.omg.PortableServer.ForwardRequest;

import java.util.ArrayList;

/**
 * @author :evan
 * @date :2018-08-21 19:16
 **/
public class Q40和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList arrayList = new ArrayList();

        int left = 1, right = 2;
        while (left < right) {
            int res = (left + right) * (right - left + 1) >> 1;
            if (res == sum) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    temp.add(i);
                }
                arrayList.add(temp);
                left++;
                right++;
            } else if (res < sum) {
                right++;
            } else {
                left++;
            }
        }
        return arrayList;


    }

    @Test
    public void test(){
        System.out.println(FindContinuousSequence(3));
    }


}
