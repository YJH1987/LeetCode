// Solution 1
public class Solution {
    public int searchInsert(int[] A, int target) {
        int L = 0, R = A.length - 1;
        while (L < R) {
            int M = (L+R) / 2;
            if (A[M] < target) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (A[L] < target) ? L + 1 : L;
    }
}

// Solution 2
public class Solution {
    public int searchInsert(int[] A, int target) {
        return binSearch(A, 0, A.length, target);
    }
    private int binSearch(int[] A, int i, int j, int target) {
        if(j <= i) return j;
        int mid = (i + j) / 2;
        if (A[mid] > target) return binSearch(A, i, mid, target);
        if (A[mid] < target) return binSearch(A, mid + 1, j, target);
        return mid;
    }
    /*
    test
    []
    [1] 1
    [1] 2
    [1] 0
    [1 2] 0
    [1 2 3] 2 
    */
}

// Solution 3
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) 
        return 0;
        return searchInsert(A, target, 0, A.length-1);
    }
 
    public int searchInsert(int[] A, int target, int start, int end) {
        int mid = (start + end) / 2;
 
        if (target == A[mid]) 
            return mid;
        else if (target < A[mid]) 
            return start < mid ? searchInsert(A, target, start, mid - 1) : start;
        else 
            return end > mid ? searchInsert(A, target, mid+1, end) : (end + 1);
    }
}
