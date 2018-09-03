package com.evan.leetcode.algorithm.DynamicPrograming;

import java.util.*;

/**
 * Created by asus on 2018/2/22.
 */
public class Q139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i])
                continue;

            for(String a: wordDict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];

    }


    private HashMap<String, Boolean> map = new HashMap<>();

    public boolean wordBreak_2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return wordBreak(s, set);

    }

    private boolean wordBreak(String s, Set set) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (set.contains(s)) {
            map.put(s, true);
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (wordBreak(left, set) && set.contains(right)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }


}
