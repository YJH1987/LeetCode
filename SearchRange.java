public class SearchRange {
    public int[] searchRange(int[] A, int target) {
	int[] range = {-1, -1};
	int start = 0;
	int end = A.length - 1;
	while (start < end) {
	    int mid = (start + end) / 2;
	    if (A[mid] < target)
		start = mid + 1;
	    else
		end = mid;
	}
	int low;
	if (A[start] != target)
	    return range;
	else
	    low = start;
	start = 0;
	end = A.length - 1;
	while (start < end) {
	    int mid = (start + end) / 2;
	    if (A[mid] < target + 1)
		start = mid + 1;
	    else
		end = mid;
	}
	int high = A[start] == target ? start : start - 1;
	range[0] = low;
	range[1] = high;
	return range;
    }
}