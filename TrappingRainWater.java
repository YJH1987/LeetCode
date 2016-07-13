// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

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
        /*
            def trap(self, A):
                maxIndex=0
                for i in range(len(A)):
                    if A[i]>A[maxIndex]:
                        maxIndex=i
                w=0
                startIndex=0
                for i in range(1,maxIndex+1):
                    if A[i]<=A[startIndex]:
                        w+=A[startIndex]-A[i]
                    else:
                        startIndex=i
                startIndex=len(A)-1
                for i in range(len(A)-1,maxIndex-1,-1):
                    if A[i]<=A[startIndex]:
                        w+=A[startIndex]-A[i]
                    else:
                        startIndex=i
                return w
        */
        int maxIndex = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i]>A[maxIndex]) maxIndex=i;
        }
        int w=0;
        int startIndex = 0;
        for(int i=1; i<=maxIndex; i++) {
            if(A[i]<=A[startIndex]) w+=A[startIndex]-A[i];
            else startIndex = i;
        }
        startIndex=A.length-1;
        for(int i=A.length-2; i>=maxIndex; i--) {
            if(A[i]<=A[startIndex]) w+=A[startIndex]-A[i];
            else startIndex = i;
        }
        return w;
    }
}
