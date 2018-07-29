    package com.evan.CSP.CCF_201703;

    import java.util.*;

    /**
     * Created by asus on 2018/3/9.
     */
    public class DiTieXiuJian {
        private static List<List<Line>> graph;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int numbers = scanner.nextInt();
            int index=numbers-1;
            graph=new ArrayList<>(numbers);
            for (int i = 0; i < numbers; i++) {
                graph.add(new LinkedList<>());
            }
            int lines = scanner.nextInt();
            for (int i = 0; i < lines; i++) {
                int from = scanner.nextInt() - 1;
                int to = scanner.nextInt() - 1;
                int day = scanner.nextInt();
                graph.get(from).add(new Line(to, day));
                graph.get(to).add(new Line(from, day));
            }

            PriorityQueue<Line> priorityQueue = new PriorityQueue<>(new Comparator<Line>() {
                @Override
                public int compare(Line o1, Line o2) {
                    if(o1.day==o2.day) return o1.to-o2.to;
                     else return o1.day - o2.day;
                }
            });
            boolean[] vis = new boolean[numbers];
            priorityQueue.offer(new Line(0, 0));
            int max = 0;
            while (!priorityQueue.isEmpty()) {
                Line poll = priorityQueue.poll();
                if (poll.to == index) {
                    max = poll.day;
                    break;
                }
                vis[poll.to] = true;
                for (Line line : graph.get(poll.to)) {
                    if (vis[line.to]) continue;
                    line.day=Math.max(poll.day,line.day);
                    priorityQueue.add(line);
                }
            }
            System.out.println(max);
        }
    }

    class Line {
        int to;
        int day;

        public Line(int to, int day) {
            this.to = to;
            this.day = day;

        }
    }