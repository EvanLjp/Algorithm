package com.evan.coding;

import org.junit.Test;
import sun.plugin2.os.windows.FLASHWINFO;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author :evan
 * @date :2018-08-21 11:39
 **/
public class Q27字符串的排列 {

    private ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if(str.length()==0) {
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backTracking(chars, new boolean[chars.length], new StringBuilder());
        return list;
    }

    private void backTracking(char[] chars, boolean[] visited, StringBuilder stringBuilder) {

        if (stringBuilder.length() == chars.length) {
            list.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (i != 0 && chars[i] == chars[i - 1]&&!visited[i-1]) {
                continue;
            }
            visited[i] = true;
            stringBuilder.append(chars[i]);
            backTracking(chars, visited, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            visited[i] = false;


        }
    }

    @Test
    public void test(){
        System.out.println(Permutation("aa"));
    }

}
