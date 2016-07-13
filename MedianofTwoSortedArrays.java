/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5*/

// Solution 1
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 < N2) return findMedianSortedArrays(nums2, nums1);   // Make sure A2 is the shorter one.

        if (N2 == 0) return ((double)nums1[(N1-1)/2] + (double)nums1[N1/2])/2;  // If A2 is empty

        int lo = 0, hi = N2 * 2;
        while (lo <= hi) {
            int mid2 = (lo + hi) / 2;   // Try Cut 2 
            int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly
    
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];  // Get L1, R1, L2, R2 respectively
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
            double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
            double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];

            if (L1 > R2) lo = mid2 + 1;     // A1's lower half is too big; need to move C1 left (C2 right)
            else if (L2 > R1) hi = mid2 - 1;    // A2's lower half too big; need to move C2 left.
            else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2; // Otherwise, that's the right cut.
        }
        return -1;
    }
}

// Solution 2
import java.util.*;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int sum = A.length + B.length;
        if(sum % 2 == 0) return (fk(A, 0, B, 0, sum / 2) + fk(A, 0, B, 0, sum / 2 - 1)) / 2.0;
        else return fk(A, 0, B, 0, sum / 2) * 1.0;
    }
    private int fk(int[] A, int ia, int[] B, int ib, int k) {
        if (A.length - ia < B.length - ib) return fk(B, ib, A, ia, k);
        if (B.length == ib) return A[ia + k];
        if (k <= 3) {
            int i = 0;
            int[] C = new int[k+1];
            while(i <= k) {
                if(ia < A.length && ib < B.length) {
                    if(A[ia] <= B[ib]) C[i++] = A[ia++];
                    else C[i++] = B[ib++];
                } else if(ia < A.length) {
                    C[i++] = A[ia++];
                } else if(ib < B.length) {
                    C[i++] = B[ib++];
                } else {
                    assert false : "wrong input.";
                }
            }
            return C[k];
        }
        int m = B.length - ib > k/2-1 ? k/2-1 : B.length - ib - 1;
        if(B[ib + m] < A[ia + k/2-1]) {
            return fk(A, ia, B, m+1 + ib, k-m-1);
        } else {
            return fk(A, ia + k/2, B, ib, k-k/2);
        }
    }
}