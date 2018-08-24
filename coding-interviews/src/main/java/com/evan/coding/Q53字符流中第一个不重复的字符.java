package com.evan.coding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :evan
 * @date :2018-08-22 15:27
 **/
public class Q53字符流中第一个不重复的字符 {

    private int[] map=new int[256];
    private Queue<Character> queue=new LinkedList<>();
    public void Insert(char ch)
    {
        map[ch]++;
        queue.offer(ch);
        while (!queue.isEmpty()&&map[queue.peek()]>1){
            queue.poll();
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(queue.isEmpty()) return '#';
        return queue.peek();
    }

}
