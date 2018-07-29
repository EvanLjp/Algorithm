package com.evan.interviews;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 21:01
 */
public class Q45_把数组排成最小的数 {
    public String PrintMinNumber(int[] numbers) {
        int length=numbers.length;
        String[] strings=new String[length];
        for (int i = 0; i < length; i++) {
            strings[i]=numbers[i]+"";
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String res="";
        for (String str:strings){
            res+=str;
        }
        return res;
    }


}
