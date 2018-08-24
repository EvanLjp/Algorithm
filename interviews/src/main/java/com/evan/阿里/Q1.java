package com.evan.阿里;

import java.util.*;

/**
 * @author :evan
 * @date :2018-08-17 17:54
 **/
public class Q1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        int [][] arr=new int[num][2];
        for (int i = 0; i < num; i++) {
            String next = scanner.next();
            String[] split = next.split(".");
            arr[i][0]=Integer.valueOf(split[0]);
            arr[i][1]=Integer.valueOf(split[1]);
        }
        Map<Integer,TreeSet<node>> map=new HashMap<>();
        for (int i = -1; i <num ; i++) {
            for (int j = 0; j <num ; j++) {
                if (i==j){
                    continue;
                }
                if (i==-1){
                    if (!map.containsKey(-1)){
                        map.put(-1,new TreeSet<>(new Comparator<node>() {
                            @Override
                            public int compare(node o1, node o2) {
                                return o1.dis-o2.dis;
                            }
                        }));
                    }
                    map.get(-1).add(new node(j,getDis(0,0,arr[j][0],arr[j][1])));
                }
                int dis=getDis(arr[i][0],arr[i][1],arr[j][0],arr[j][1]);
                if (!map.containsKey(i)){
                    map.put(i,new TreeSet<>(new Comparator<node>() {
                        @Override
                        public int compare(node o1, node o2) {
                            return o1.dis-o2.dis;
                        }
                    }));
                }
                map.get(i).add(new node(j,getDis(arr[i][0],arr[i][1],arr[j][0],arr[j][1])));
            }
        }
        Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });


        queue.offer(map.get(-1).first().number);
       /* while ()*/



    }

    private static int getDis(int i, int i1, int i2, int i3) {
        return Math.abs(i2-i)+Math.abs(i3-i1);
    }

    static class node{
        int number;
        int dis;

        public node(int number, int dis) {
            this.number = number;
            this.dis = dis;
        }
    }


}
