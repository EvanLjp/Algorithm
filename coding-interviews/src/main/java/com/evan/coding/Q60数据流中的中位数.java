package com.evan.coding;

import java.time.OffsetDateTime;
import java.util.PriorityQueue;

/**
 * @author :evan
 * @date :2018-08-22 16:33
 **/
public class Q60数据流中的中位数 {

    private PriorityQueue<Integer> max = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private boolean odd = true;

    public void Insert(Integer num) {
        if (odd) {
            min.add(num);
            max.add(min.poll());
        } else {
            max.add(num);
            min.add(max.poll());
        }
        odd = !odd;

    }

    public Double GetMedian() {
        if (odd) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return (double) max.peek();
        }
    }

}
