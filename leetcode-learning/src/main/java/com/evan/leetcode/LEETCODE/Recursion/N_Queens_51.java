package com.evan.leetcode.LEETCODE.Recursion;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/14.
 */
public class N_Queens_51 {
    boolean[] colMap,diaMap1,diaMap2;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new LinkedList<>();
        colMap =new boolean[n];
        diaMap1=new boolean[2*n-1];
        diaMap2=new boolean[2*n-1];
        int[] temp=new int[n];
        for (int i = 0; i < n; i++) temp[i]=-1;
        getRes(res,temp,0,n);
        return res;
    }

    private void getRes(List<List<String>> res, int[] temp, int index,int n) {
        if(index==n){
            res.add(generateMap(temp,n)
            );
        }
        for (int i = 0; i < n; i++) {
            int index1=index+i,index2=index-i+n-1;
            if(!colMap[i]&&!diaMap1[index1]&&!diaMap2[index2]){
                colMap[i]=true;
                diaMap1[index1]=true;
                diaMap2[index2]=true;
                temp[index]=i;
                getRes(res,temp,index+1,n);
                temp[index]=-1;
                colMap[i]=false;
                diaMap1[index1]=false;
                diaMap2[index2]=false;
            }

        }
    }

    private List<String> generateMap(int[] temp,int n) {
        List<String> list=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb=new StringBuffer();
            for (int j = 0; j < n; j++) {
                if(j==temp[i]) sb.append('Q');
                else sb.append('.');
            }
            list.add(sb.toString());
        }
        return list;
    }

    @Test
    public void test(){
        System.out.println(solveNQueens(4));
    }


}
