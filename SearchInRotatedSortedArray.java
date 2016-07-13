// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// You are given a target value to search. If found in the array return its index, otherwise return -1.
// You may assume no duplicate exists in the array.

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int n = A.length;
	int l = 0;
	int r = n - 1;
	while (l <= r) {
	    int m = l + (r - l) / 2;
	    if (A[m] == target) return m;
	    
	    if (A[l] <= A[m]) {
		if (A[l] <= target && target < A[m]) 
		    r = m - 1;
		else
		    l = m + 1;
	    }

	    else {
		if (A[m] < target && target <= A[r])
		    l = m + 1;
		else
		    r = m - 1;
	    }		
	}
	return -1;
    }
}

--------------------------------------------------------------

public class Solution {
    public int search(int[] A, int target) {
        return search0(A, 0, A.length, target);
    }
    private int search0(int[] A, int i, int j, int t) {
        /*
            if j<=i:
                return -1;
            mid = (i+j)/2;
            if A[mid]>A[i]:
                if A[i]<=t<A[mid]:
                    return s0(A, i, mid, t)
                else if A[mid]<t || t<A[i]:
                    return s0(A, mid+1, j, t)
                else:
                    return mid
            else: 
                #assert A[mid]<A[i]
                if A[i]<=t || t<A[mid]:
                    return s0(A,i, mid, t)
                else if A[mid]<t<A[i]:
                    return s0(A, mid+1, j, t)
                else:
                    return mid
        */
        
        if(j <= i) return -1;
        if(j == i+1 && A[i]==t) return i;
        int mid = (i + j) / 2;
        if(A[mid] > A[i]) {
            if(A[i]<=t && t<A[mid]) return search0(A, i, mid, t);
            else if(A[mid]<t || t<A[i]) return search0(A, mid+1, j, t);
            else return mid;
        } else {
            if(A[i]<=t || t<A[mid]) return search0(A, i, mid, t);
            else if(A[mid]<t && t<A[i]) return search0(A, mid+1, j, t);
            else return mid;
        }
    }
}