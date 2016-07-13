/*Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

// Solution 1
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        if (points.length <= 2) {
            return points.length;
        }

        int ret = 0;
        int n = points.length;
        int count = 0;
        int duplicates = 0;

        for (int i = 0; i < n; i++) {
            Point p = points[i];
            count = 0;
            duplicates = 0;

            for (int j = i + 1; j < n; j++) {
                Point q = points[j];
                if (q.x == p.x && q.y == p.y) {
                    duplicates++;
                    ret = Math.max(ret, duplicates + 1);
                    continue;
                }
                //count point q
                count = 1;
  
                for (int k = j + 1; k < n; k++) {
                    Point r = points[k];
                    count += isCoLinear(p, q, r) ? 1 : 0;
                }
                //count point p
                ret = Math.max(ret, count + duplicates + 1);
            }
        }
        return ret;
    }

    private boolean isCoLinear(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x);
        return val == 0;
    }
}

// Solution 2
import java.util.*;
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int m = 2;
        for (int i = 0; i < points.length; i++) {
            int cnt = 1;
            ArrayList<Double> ratios = new ArrayList<Double>();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) cnt++;
                else ratios.add(calcRatio(points[i], points[j]));
            }
            m = Math.max(m, maxSimilar(ratios.toArray(new Double[ratios.size()])) + cnt);
        }
        return m;
    }
    private double calcRatio(Point a, Point b) {
        if (a.x == b.x) return Math.atan(0x7fffffffffffffff L);
        return Math.atan((a.y - b.y) * 1.0 / (a.x - b.x));
    }
    private int maxSimilar(Double[] rs) {
        Arrays.sort(rs);
        if (rs.length <= 1) return rs.length;
        int m = 1, cur = 1;
        for (int i = 1; i < rs.length; i++) {
            if (Math.abs(rs[i] - rs[i - 1]) < 1e-7) {
                cur++;
                m = Math.max(m, cur);
            } else cur = 1;
        }
        return m;
    }
}