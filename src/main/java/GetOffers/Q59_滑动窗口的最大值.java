package GetOffers;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q59_滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res=new ArrayList<>();
        if (num==null||num.length==0||size<=0||num.length<size)
            return res;
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int i = 0; i <num.length ; i++) {
            while (!linkedList.isEmpty()&&num[linkedList.peekLast()]<num[i])
                linkedList.pollLast();
            linkedList.addLast(i);
            if(linkedList.peekFirst()==i-size)
                linkedList.pollFirst();
            if (i>=size-1)
                res.add(num[linkedList.peekFirst()]);
        }
        return res;
    }

}
