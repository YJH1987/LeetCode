/*Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?*/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        
        for (int x: nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i+1);
            dp[i] = x;
            if (i == len) len++;
            
        }
        return len;
    }
}

----------------------------------------------------------------------------------------

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        for (int index = 0; index < nums.length; index++) {
            dp[index] = 1;
            for (int dpIndex=0; dpIndex<index; dpIndex++) {
                if (nums[dpIndex] < nums[index]) {
                    dp[index] = Math.max(dp[index], dp[dpIndex]+1);
                    max = Math.max(dp[index], max);
                }
            }
        }
        return max;
    }
}