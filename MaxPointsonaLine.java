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
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 0) return 0;
        if (points.length <= 2) return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) {
                        samep++;
                    }
                    if (points[j].x == points[i].x) {
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if (hm.containsKey(k)) {
                        hm.put(k, hm.get(k) + 1);
                    } else {
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
}