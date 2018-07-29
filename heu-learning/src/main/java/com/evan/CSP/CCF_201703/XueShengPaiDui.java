package com.evan.CSP.CCF_201703;

import java.util.Scanner;

/**
 * Created by asus on 2018/3/9.
 */
public class XueShengPaiDui {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numbers = scanner.nextInt();
        Node head=new Node(null,null,0);
        Node cur=head;
        for (int i = 1; i <=numbers ; i++) {
            Node temp=new Node(cur,null,i);
            cur.next=temp;
            cur=temp;
        }
        int lines = scanner.nextInt();
        for (int i = 0; i <lines ; i++) {
            cur=head;
            int val = scanner.nextInt();
            int command = scanner.nextInt();
            while (cur.value!=val){
                cur=cur.next;
            }
            if(cur.pre!=null)cur.pre.next=cur.next;
            if(cur.next!=null) cur.next.pre=cur.pre;
            Node todo=cur;
            int count=0;
            if(command>0){
                while (count<command){
                    cur=cur.next;
                    count++;
                }
                todo.next=cur.next;
                todo.pre=cur;
                cur.next=todo;
                if(todo.next!=null)todo.next.pre=todo;
            }else {
                while (count>command){
                    cur=cur.pre;
                    count--;
                }
                todo.next=cur;
                todo.pre=cur.pre;
                cur.pre=todo;
                if(todo.pre!=null)todo.pre.next=todo;
            }


        }

        while (head.next!=null){
            if(head.next.next!=null) System.out.print(head.next.value+" ");
            else System.out.print(head.next.value);
           head=head.next;
        }

    }
}

class Node{
    public Node pre;
    public Node next;
    public int value;

    public Node(Node pre, Node next, int value) {
        this.pre = pre;
        this.next = next;
        this.value = value;
    }
}