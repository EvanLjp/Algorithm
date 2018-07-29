package com.evan.CSP.CCF_201609;

import java.util.*;

/**
 * Created by asus on 2018/3/15.
 */
public class JiaoTongGuiHua {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        ArrayList<List<Line>> map = new ArrayList<>(numbers);
        int lines = scanner.nextInt();
        for (int i = 0; i < numbers; i++) {
            map.add(new LinkedList<Line>());
        }
        for (int i = 0; i < lines; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            map.get(from).add(new Line(to, scanner.nextInt()));
        }
        boolean[] vis = new boolean[numbers];
        PriorityQueue<Line> queue=new PriorityQueue<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return 0;
            }
        });
    }

}

class Line {
    public int to;
    public int value;

    public Line(int to, int value) {
        this.to = to;
        this.value = value;
    }
}
