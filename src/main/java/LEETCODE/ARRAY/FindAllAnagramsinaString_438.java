package LEETCODE.ARRAY;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/1/7.
 */
public class FindAllAnagramsinaString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] flag = new int[256];
        for (char c : p.toCharArray()) {
            flag[c]++;
        }
        int leftIndex=0;
        int rightIndex=0;
        int count=p.length();
        char[] chars = s.toCharArray();

        List<Integer> res=new ArrayList<>();
        while (rightIndex<s.length()){
            if(flag[chars[rightIndex++]]-->0) count--;
            if(count==0) res.add(leftIndex);
            if(rightIndex-leftIndex==p.length()&&flag[chars[leftIndex++]]++>=0) count++;
        }
        return res;



       /* public List<Integer> findAnagrams(String s, String p) {
            int[] map = new int[256];
            for(char c : p.toCharArray()) map[c]++;
            int slow = 0, fast = 0, count = p.length();
            List<Integer> res = new ArrayList<>();
            while(fast < s.length()){
                char c = s.charAt(fast);
                if(map[c] > 0) count--;
                map[c]--;
                fast++;
                while(count == 0){
                    if(fast - slow == p.length()) res.add(slow);
                    char cc = s.charAt(slow);
                    map[cc]++;
                    if(map[cc] > 0) count++;
                    slow++;
                }
            }
            return res;
        }*/
    }

    @Test
    public void test(){
        String a="cbaebabacd";
        String b="abc";
        List<Integer> list = findAnagrams(a, b);
        System.out.println(list);
    }

}
