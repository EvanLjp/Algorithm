package com.evan.leetcode.algorithm.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by asus on 2018/2/25.
 */
public class Non_overlappingIntervals_435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length==0) return 0;
        List<Interval> intervals1 = Arrays.asList(intervals);
        Collections.sort(intervals1, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.end!=o2.end) return o1.end-o2.end;
                else return o1.start-o2.start;
            }
        });
        int res=1;
        int index=0;
        for (int i = 1; i <intervals1.size(); i++) {
            if(intervals1.get(index).end<=intervals1.get(i).start) {
                res++;
                index=i;
            }
        }

        return intervals1.size()-res;
    }


    @Test
    public void test(){
        Interval a1=new Interval();
        a1.start=0;
        a1.end=2;
        Interval a2=new Interval();
        a2.start=1;
        a2.end=3;
         Interval a3=new Interval();
        a3.start=2;
        a3.end=4;
         Interval a4=new Interval();
        a4.start=3;
        a4.end=5;
         Interval a5=new Interval();
        a5.start=4;
        a5.end=5;

        Interval[] arr=new Interval[]{a1,a2,a3,a4,a5};
        System.out.println(eraseOverlapIntervals(arr));
    }



}
