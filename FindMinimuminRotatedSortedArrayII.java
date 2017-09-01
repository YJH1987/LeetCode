/*Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.*/

public class Solution {
    public int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        
        while (num[hi] == num[lo] && hi > lo) {
            hi--;
        }
        
        while (num[lo] > num[hi]) {
            int mid = lo + (hi - lo) / 2;
            if (num[mid] > num[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return num[lo];   
    }
}