package com.evan.interviews;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 13:03
 */
public class Q38_字符串的排列 {
    private ArrayList<String> res=new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if(str.length()==0) return res;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars,new boolean[chars.length],new StringBuilder());
        return res;

    }

    private void backtracking(char[] chars, boolean[] vis, StringBuilder temp) {
        if(chars.length==temp.length()) {
            res.add(temp.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if(vis[i]) continue;
            if(i!=0&&chars[i]==chars[i-1]&&!vis[i-1]) continue;
            vis[i]=true;
            temp.append(chars[i]);
            backtracking(chars,vis,temp);
            temp.deleteCharAt(temp.length()-1);
            vis[i]=false;
        }

    }

    @Test
    public void test(){
        System.out.println(Permutation("aa"));
    }

}
