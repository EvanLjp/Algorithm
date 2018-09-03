package com.evan.leetcode.algorithm.recursion;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/11.
 */
public class Q401BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        int[] map = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        List<String> res = new LinkedList<>();
        getRes(map, num, res, 0,0,0);
        return res;
    }

    private void getRes(int[] map, int num, List<String> res,int hour, int minute, int index) {
        if (num == 0) {
            StringBuffer sb = new StringBuffer();
            sb.append(hour);
            sb.append(':');
            if (minute < 10) sb.append('0');
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < 10; i++) {
          if(i<4&&hour+map[i]>11) {
              i=3;
              continue;
          }
          if(i>=4&&minute+map[i]>59) break;
          if(i<4) getRes(map, num-1, res, hour+map[i],minute, i+1);
          else getRes(map, num-1, res, hour,minute+map[i], i+1);
        }
    }

    @Test
    public void test(){
        System.out.println(readBinaryWatch(2));
    }

}
