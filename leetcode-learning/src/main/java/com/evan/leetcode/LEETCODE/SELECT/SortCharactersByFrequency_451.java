package com.evan.leetcode.LEETCODE.SELECT;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by asus on 2018/1/7.
 */
public class SortCharactersByFrequency_451 {

    //超时
   /* public String frequencySort(String s) {
        if(s==null||s.length()==0) return "";
        Map<Integer,List<Character>> hash=new HashMap<>();
        int[] map=new int[256];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]]++;
        }
        for (int i = 0; i < map.length; i++) {
            if(map[i]!=0){
                if (hash.containsKey(map[i])){
                    hash.get(map[i]).add((char)i);
                }else {
                    List<Character> list=new LinkedList<>();
                    list.add((char)i);
                    hash.put(map[i],list);
                }
            }
        }
        Arrays.sort(map);
        String res="";
        for(int i=map.length-1;map[i]!=0;){
            int f = map[i];
            List<Character> characters = hash.get(f);
            for (char c:characters) {
                for (int j = 0; j < f; j++) {
                    res+=c;
                }
                i--;
            }
        }
        return res;
    }*/
    public String frequencySort(String s) {
        int[][]res=new int[256][2];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res[chars[i]][0]++;
            res[chars[i]][1]=chars[i];
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        StringBuilder sb=new StringBuilder();
        for (int i = 0;res[i][0]!=0; i++) {
            for (int j = 0; j < res[i][0]; j++) {
                sb.append((char) res[i][1]);
            }
        }
        return sb.toString();
    }
    //优先队列
   /* private static class Item {
        char ch;
        int count;

        Item() {}

        Item(char v, int n) {
            ch = v;
            count = n;
        }
    }

    public String frequencySort(String s) {
        if(s==null || s.isEmpty()) return s;

        char[] chs = s.toCharArray();
        int R = 256;

        int[] arr = new int[R];
        for (char ch: chs) arr[ch]++;
        PriorityQueue<Item> pq = new PriorityQueue<Item>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.count - o1.count;
            }
        });
        for (int i = 0; i < R; i++) {
            if (arr[i] != 0)
                pq.offer(new Item((char)i, arr[i]));
        }

        int i = 0;
        while (!pq.isEmpty()) {
            Item t = pq.poll();
            for (int j = 0; j < t.count; j++) {
                chs[i++] = t.ch;
            }
        }
        return new String(chs);
    }*/



    @Test
    public void test(){
        String s="tree";
        System.out.println(frequencySort(s));
    }


}
