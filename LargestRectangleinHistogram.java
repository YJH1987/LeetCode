/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.*/

// Solution 1
public class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}

// Solution 2
import java.util.*;
public class Solution {
    public int largestRectangleArea(int[] height) {
        int rv = 0;
        ArrayDeque<Integer> s = new ArrayDeque<Integer>();
        for(int h : height) {
            if(s.isEmpty() || h>=s.peek()) s.push(h);
            else {
                int w = 1;
                while(s.size()>0 && s.peek()>h) {
                    rv = Math.max(rv, s.peek()*w);
                    w++;
                    s.pop();
                }
                while(w-->0) s.push(h);
            }
        }
        int w = 1;
        while(s.size()>0) {
            rv = Math.max(rv, s.peek()*w);
            w++;
            s.pop();
        }
        return rv;
    }
}
