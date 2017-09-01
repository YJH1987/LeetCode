/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.*/

// Solution 2
public class Solution {
    public int maxSubArray(int[] A) {
        int maxLocal = A[0];
        int maxAll = A[0];
        for (int i = 1; i < A.length; i++) {
            maxLocal = Math.max(maxLocal + A[i], A[i]);
            maxAll = Math.max(maxLocal, maxAll);
        }
        return maxAll;
    }
}

// Solution 1
public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int sum = A[0] > 0 ? A[0] : 0;
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}