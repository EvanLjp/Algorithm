package com.evan.CSP.CCF_201712;

import java.util.Scanner;

/**
 * Created by asus on 2018/3/1.
 */
public class Game {
    static class Node {
        public int position;
        public Node next;

        public Node(int position) {
            this.position = position;
        }
    }

    public static Node createCircle(int number) {
        Node head = new Node(0);
        Node cur = head;
        for (int i = 0; i < number; i++) {
            cur.next = new Node(i + 1);
            cur = cur.next;
        }
        cur.next = head.next;
        return cur;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int flag = scanner.nextInt();
        Node pre = createCircle(number);
        Node cur = pre.next;


        int temp = 0;
        while (cur.next != cur) {
            temp++;
            if (temp%flag==0||temp%10==flag) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;

            }
        }

        System.out.println(cur.position);
    }
}
