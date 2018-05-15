package GetOffers;

import HeuAlgorithmCourse.report1.QuickSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 19:21
 */
public class Q41_2_字符流中第一个不重复的字符 {

    private int[] map = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        map[ch]++;
        queue.offer(ch);
        while (!queue.isEmpty() && map[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (queue.isEmpty()) return '#';
        return queue.peek();
    }
}
