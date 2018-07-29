package com.evan.CSP.CCF_201709;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by asus on 2018/3/6.
 */
public class GongGongYaoShiHe {
private static int [] res;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();
        int lines = scanner.nextInt();
        res=new int[number+1];
        for (int i = 0; i <=number; i++) {
            res[i]=i;
        }
        TreeSet<Integer> treeSet=new TreeSet<>();
        PriorityQueue<Node> input=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start-o2.start;
            }
        });
        PriorityQueue<Node> output=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.end==o2.end) return o1.keyNum-o2.keyNum;
                else return o1.end-o2.end;
            }
        });
        for (int i = 0; i < lines; i++) {
            int k = scanner.nextInt();
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            input.offer(new Node(k,s,s+t));
        }

        while (!input.isEmpty()){
            Node peek = input.peek();
            while (!output.isEmpty()&&output.peek().end<=peek.start){
                Node poll = output.poll();
                int index = treeSet.pollFirst();
                res[index]=poll.keyNum;
            }
            Node poll = input.poll();
            int position = findKey(poll.keyNum);
            treeSet.add(position);
            res[position]=0;
            output.offer(poll);
        }
        while (!output.isEmpty()){
            Node poll = output.poll();
            Integer index = treeSet.pollFirst();
            res[index]=poll.keyNum;
        }
        for (int i = 1; i < res.length; i++) {
            if(i==number){
                System.out.println(res[i]);
                continue;
            }
            System.out.print(res[i]+" ");
        }

    }
    private static int findEmpty(){
        for (int i = 1; i < res.length; i++) {
            if (res[i]==0) return i;
        }
        return 0;
    }

    private static int findKey(int key){
        for (int i = 0; i < res.length; i++) {
            if (res[i]==key) return i;
        }
        return 0;
    }




}

class Node{
    public int keyNum;
    public int start;
    public int end;

    public Node(int keyNum, int start, int end) {
        this.keyNum = keyNum;
        this.start = start;
        this.end = end;
    }
}