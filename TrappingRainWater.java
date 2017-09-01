// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
// compute how much water it is able to trap after raining.

// Solution 1
import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] A) {
        int curr = 0;
        while (curr < A.length && A[curr] == 0) ++curr;
	
        int vol = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	while (curr < A.length) {
            while(!stack.isEmpty() && A[curr] >= A[stack.peek()]) {
                int b = stack.pop();
                if (stack.isEmpty()) break;
                vol += ((curr - stack.peek() - 1) * (Math.min(A[curr], A[stack.peek()]) - A[b]));
            }
            stack.push(curr);
            ++curr;
        }
        return vol;
    }
}

// Solution 2
public class Solution {
    public int trap(int[] A) {
        if (A.length < 3) return 0;

        int ans = 0;
        int l = 0, r = A.length - 1;

        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1]) l++;
        while (l < r && A[r] <= A[r - 1]) r--;

        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volume until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volume until an edge larger than the right volum
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }
}