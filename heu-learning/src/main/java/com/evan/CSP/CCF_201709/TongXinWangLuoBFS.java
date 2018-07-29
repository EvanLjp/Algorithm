package com.evan.CSP.CCF_201709;

import java.util.*;

/**
 * Created by asus on 2018/3/8.
 */
public class TongXinWangLuoBFS {
    private static List<List<Integer>> graph=new ArrayList<>(1005);
    private static boolean[][]know;
    private static int numbers;
    private static int now;
    private static boolean[]visisted;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = scanner.nextInt();
        int lines = scanner.nextInt();
        for (int i = 0; i < numbers; i++) {
            graph.add(new ArrayList<>());
        }
        know=new boolean[numbers][numbers];
        for (int i = 0; i < lines; i++) {
            graph.get(scanner.nextInt()-1).add(scanner.nextInt()-1);
        }
        Queue<Integer> queue=new LinkedList();
        for (int i = 0; i < numbers; i++) {
            visisted=new boolean[numbers];
            now=i;
            queue.add(i);
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                know[poll][now]=know[now][poll]=visisted[poll]=true;
                for (int j:graph.get(poll)){
                    if(visisted[j])continue;
                    queue.offer(j);
                }
            }
        }
        int count=0;
        for (int i = 0; i < numbers; i++) {
            for (int j = 0; j < numbers; j++) {
                if(!know[i][j]) {
                    break;
                }
                if(j==numbers-1) count++;
            }

        }
        System.out.println(count);
    }


}
