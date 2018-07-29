package com.evan.interviews;

import org.junit.Test;

/**
 * @Auther: Evan.
 * @Description:
 * @CreateDate: 2018/5/13 8:40
 */
public class Q50_第一个只出现一次的字符位置 {

    public int FirstNotRepeatingChar(String str) {
        int[]map=new int[256];
        char[] chars = str.toCharArray();
        for (char c:chars){
            map[c]++;
        }
        for (int i = 0; i <chars.length ; i++) {
            if(map[chars[i]]==1)
                return i;
        }
        return -1;


    }

    @Test
    public void test(){
        System.out.println(FirstNotRepeatingChar("google"));
    }



}
