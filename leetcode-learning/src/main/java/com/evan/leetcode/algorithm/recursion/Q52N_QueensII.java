package com.evan.leetcode.algorithm.recursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/14.
 */
public class Q52N_QueensII {
    boolean[] colMap,diaMap1,diaMap2;
    int res=0;
    public int totalNQueens(int n) {
        colMap =new boolean[n];
        diaMap1=new boolean[2*n-1];
        diaMap2=new boolean[2*n-1];
        getRes(0,n);
        return res;
    }
    private void getRes(  int index,int n) {
        if(index==n){
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int index1=index+i,index2=index-i+n-1;
            if(!colMap[i]&&!diaMap1[index1]&&!diaMap2[index2]){
                colMap[i]=true;
                diaMap1[index1]=true;
                diaMap2[index2]=true;
                getRes(index+1,n);
                colMap[i]=false;
                diaMap1[index1]=false;
                diaMap2[index2]=false;
            }

        }
    }
    @Test
    public void test(){
        System.out.println(totalNQueens(4));
    }
}
