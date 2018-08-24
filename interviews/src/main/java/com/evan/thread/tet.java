package com.evan.thread;

import java.util.ArrayList;

/**
 * @author :evan
 * @date :2018-08-18 22:02
 **/
public class tet {


    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        for (int i:arrayList){
            System.out.println(i);
            if (i==4){
                arrayList.remove(i);
            }
        }
    }
}
