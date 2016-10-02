/*Implement int sqrt(int x).

Compute and return the square root of x.*/

public class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long start = 1, end = x;
        while (start < end - 1) {
            long mid = start + (end - start) / 2;
            if (mid * mid > x) end = mid;
            else if (mid * mid < x) start = mid;
            else return (int) mid;
        }
        if (end * end <= x) return (int)end;
        else return (int)start;
    }
}