/* Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n^2. */

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = n;
            for (int[] row : matrix) {
                while (j >= 1 && row[j - 1] > mid) j--;
                count += j;
            }
            
            if (count < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}