/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.*/

public class Solution {
    public int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
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