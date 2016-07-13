// Given a sorted array of integers, find the starting and ending position of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].
// For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].

public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int[] range = {-1, -1};
	int low = 0;
	int high = A.length - 1;
	while (low <= high) {
	    int mid = (low + high) / 2;
	    if (A[mid] == target) {
		if (mid == 0 || A[mid - 1] < target) {
		    range[0] = mid;
		    low = mid;
		    high = A.length - 1;
		}

		if (mid == A.length - 1 || A[mid + 1] > target) {
		    range[1] = mid;
		    low = 0;
		    high = mid;
		}

		if (range[0] > -1 && range[1] > -1)  return range;
		if (range[0] < 0) high = mid - 1;
		else low = mid + 1;
	    } else if (A[mid] < target) {
		low = mid + 1;
	    } else {
		high = mid - 1;
	    }
	}
	return range;
    }
}