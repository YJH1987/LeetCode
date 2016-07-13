/*Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.*/

public class NumArray {
    int[] tree;
    int[] nums;
    int size;
    public NumArray(int[] nums) {
        this.size = nums.length;
        this.tree = new int[size + 1];
        this.nums = new int[size];
        this.nums = nums;
        for (int i = 0; i < size; i++) {
            updateTree(i, nums[i]);
        }
    }

    public void updateTree(int i, int val) {
        i = i + 1;
        while (i <= size) {
            tree[i] += val;
            i += i & (-i); // the last set bit/ Two's complement
        }
    }

    public void update(int i, int val) {
        updateTree(i, val - nums[i]);
        nums[i] = val;
    }

    private int getSum(int i) {
        int sum = 0;
        i = i + 1;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i); // Another tree, go to the ancestor
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        if (i == 0) return getSum(j);
        return getSum(j) - getSum(i - 1);
    }

}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);