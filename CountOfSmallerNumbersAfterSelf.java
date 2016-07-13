/*You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].*/

public class Solution {

    /*
    In this solution, we use a binary indexed tree (BIT)
    Our assumption is that all elements in nums are positive
    */

    static int MAX = 11000; //we set max value that can be store in the tree
    int[] tree = new int[MAX];

    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];

        //make all elements in the array posive while maintaining their order
        makePositive(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = get(nums[i]);
            add(nums[i] + 1, 1);
        }
        return Arrays.asList(result);
    }

    public void makePositive(int[] nums) {
        int min = MAX;
        for (int i = 0; i < nums.length; i++)
            min = Math.min(min, nums[i]);
        if (min < 0) {
            min = -min + 1;
            for (int i = 0; i < nums.length; i++)
                nums[i] += min;
        }
    }

    public void add(int idx, int val) {
        while (idx < MAX) {
            tree[idx] += val;
            idx += (idx & (-idx));
        }
    }

    public int get(int idx) {
        int result = 0;
        while (idx > 0) {
            result += tree[idx];
            idx &= (idx - 1);
        }
        return result;
    }
}