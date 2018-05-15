package GetOffers;

import LEETCODE.Recursion.LetterCombinationsofaPhoneNumber_17;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 17:18
 */
public class Q41_1_数据流中的中位数 {

    PriorityQueue<Integer> max=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    private PriorityQueue<Integer> min=new PriorityQueue<>();
    private boolean isOdd=true;
    public void Insert(Integer num) {
        if(isOdd){
            min.add(num);
            max.add(min.poll());//维护小的数据在max堆
        }else {
            max.add(num);
            min.add(max.poll());//维护大的数据在min堆
        }
        isOdd=!isOdd;
    }

    public Double GetMedian() {
        if(isOdd){
            return (min.peek()+max.peek())/2.0;
        }else return (double) max.peek();
    }

}
