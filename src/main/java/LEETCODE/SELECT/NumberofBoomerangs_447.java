package LEETCODE.SELECT;

import java.util.HashMap;

/**
 * Created by asus on 2018/1/14.
 */
public class NumberofBoomerangs_447 {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int length = getLength(points[i], points[j]);
                Integer count = map.getOrDefault(length, 0);
                map.put(length, count + 1);
            }
            for (int f : map.values()) {
                res += f * (f - 1);
            }
            map.clear();
        }
        return res;
    }

    private int getLength(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }


}
