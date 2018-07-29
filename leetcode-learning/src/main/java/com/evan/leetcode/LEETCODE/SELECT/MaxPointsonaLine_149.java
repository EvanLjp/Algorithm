package com.evan.leetcode.LEETCODE.SELECT;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/1/14.
 */
public class MaxPointsonaLine_149 {

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    private double getK(Point A, Point B) {
        BigDecimal a=new BigDecimal((double) (A.y - B.y));
        BigDecimal b=new BigDecimal((double) (A.x - B.x));
        BigDecimal divide = a.divide(b,16,BigDecimal.ROUND_HALF_UP);

        return divide.doubleValue() ;
    }


    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        int res = -1;
        int same=0;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(Double.MAX_VALUE, 1);
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y){
                    same++;
                    continue;
                }
                if (points[i].x == points[j].x) map.put(Double.MAX_VALUE, map.get(Double.MAX_VALUE) + 1);
                else {
                    double K = getK(points[i], points[j]);
                    int count = map.getOrDefault(K, 1);
                    map.put(K, count + 1);
                }

            }
            for (int f : map.values()) {
                res = f+same > res ? f+same : res;
            }
            map.clear();
            same=0;
        }
        return res;

    }

    //10ms

        public int maxPoints2(Point[] points) {
            if (points == null) {
                return 0;
            }
            if (points.length <= 2) {
                return points.length;
            }
            int n = points.length;
            int max = 2;
            Point a, b, c;
            for (int i = 1; i < n; i++) {
                a = points[i - 1];
                b = points[i];
                double k = getSlop(a, b);
                int count = 2;
                for (int j = 0; j < n; j++) {
                    if (j == i || j == i - 1) {
                        continue;
                    }
                    c = points[j];
                    if (overlap(a, c) || overlap(b, c) || k == getSlop(b, c)) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
            return max;
        }

        private boolean overlap(Point a, Point b) {
            return a.x == b.x && a.y == b.y;
        }

        private double getSlop(Point a, Point b) {
            if (a.x == b.x) {
                return Double.POSITIVE_INFINITY;
            } else {
                return ((double) a.y - b.y) / ((double) a.x - b.x);
            }
        }




    @Test
    public void test(){
        Point c=new Point(0,0);
        Point a=new Point(94911151,94911150);
        Point b=new Point(94911152,94911151);
        Point[] aa={a,c,b};
        maxPoints2(aa);

    }


}
