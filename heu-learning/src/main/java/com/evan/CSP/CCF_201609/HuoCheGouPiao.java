package com.evan.CSP.CCF_201609;

import java.util.Scanner;

/**
 * Created by asus on 2018/3/14.
 */
public class HuoCheGouPiao {

    public static void main(String[] args) {
        node head=new node(-1,0,0,null);
        node cur=head;
        for (int i = 0; i < 20; i++) {
            cur.next=new node(i,5,0,null);
            cur=cur.next;
        }
        Scanner scanner=new Scanner(System.in);
        int orders = scanner.nextInt();
        int[] res=new int[orders];
        for (int i = 0; i < orders; i++) {
            res[i]=scanner.nextInt();
        }
        for (int i = 0; i < orders; i++) {
            int count=res[i];
            node getline = getline(head.next, count);
            int start=(getline.index)*5+(getline.from-count);
            for (int j = 0; j <count ; j++) {

                if(j==count-1)  System.out.print(start+j+1);
                else System.out.print(start+j+1+" ");
            }

            System.out.println();
        }


    }

    private  static node getline(node node,int need){
        while (node!=null){
            if(node.empty>=need){
                node.empty=node.empty-need;
                node.from+=need;
                return node;
            }
            node=node.next;
        }
        return null;
    }


static class node{
        int index;
        int empty;
        int from;
        public node next;

    public node(int index, int empty, int from, node next) {
        this.index = index;
        this.empty = empty;
        this.from = from;
        this.next = next;
    }
}





}
