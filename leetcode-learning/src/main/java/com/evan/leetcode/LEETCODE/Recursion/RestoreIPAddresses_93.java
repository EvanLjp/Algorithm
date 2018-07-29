package com.evan.leetcode.LEETCODE.Recursion;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/10.
 */
public class RestoreIPAddresses_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new LinkedList<>();
        if(s.length()>=4&&s.length()<=12)
        getRes(result,s,0,new LinkedList<>());
        return result;
    }

    private void getRes(List<String> result, String s, int i,List<String> temp) {
        if(i==4&&s.equals("")) {
            StringBuffer sb = new StringBuffer();
            for(String tmp: temp){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        for (int j = 1; j < 4&&j<=s.length(); j++) {
            String substring = s.substring(0, j);
            if(j>1&&substring.charAt(0)=='0')continue;
            int number = Integer.parseInt(substring);
            if(number>=0&&number<=255){
                temp.add(substring);
                getRes(result,s.substring(j),i+1,temp);
                temp.remove(temp.size()-1);
            }
        }

    }

    @Test
    public  void test(){
        System.out.println(restoreIpAddresses("0000"));
    }



}
