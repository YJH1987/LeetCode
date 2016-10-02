/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. */

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = 0, end = A.length - 1;
        int[] ret = new int[]{-1, -1};
        // Search for the left one
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target) start = mid + 1;
            else end = mid;
        }
        if (A[start] != target) return ret;
        else ret[0] = start;

        // Search for the right one
        end = A.length - 1; // We don't have to set start to 0 the second time.
        while (start < end) {
            int mid = (start + end) / 2 + 1; // Make mid biased to the right
            if (A[mid] > target) end = mid - 1;
            else start = mid; // So that this won't make the search range stuck.
        }
        ret[1] = end;
        return ret;
    }
}