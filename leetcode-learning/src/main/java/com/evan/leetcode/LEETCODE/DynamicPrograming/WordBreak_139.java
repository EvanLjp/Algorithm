package com.evan.leetcode.LEETCODE.DynamicPrograming;

import java.util.List;

/**
 * Created by asus on 2018/2/22.
 */
public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] map=new boolean[length +1];
        map[0]=true;
        for (int i = 0; i <=length ; i++) {
            StringBuilder sb=new StringBuilder(s.substring(0,i));
            for (int j = 1; j <=i ; j++) {
                if(wordDict.contains(sb.toString())&&map[j-1]){
                    map[i]=true;
                    break;
                }

                sb.deleteCharAt(0);
            }
            
        }
        return map[length];

    }





}
