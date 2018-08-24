package com.evan.coding;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author :evan
 * @date :2018-08-22 16:41
 **/
public class Q61滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || num.length < size||size<=0) {
            return new ArrayList<>();
        }
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() == i - size) {
                queue.pollFirst();
            }
            if (i >= size - 1) {
                res.add(num[queue.peekFirst()]);
            }
        }

        return res;

    }

}
