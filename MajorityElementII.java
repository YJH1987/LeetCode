/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int a = 0, b = 0;

        for (int n: nums) {
            if (cnt1 == 0 || n == a) {
                cnt1++;
                a = n;
            } else if (cnt2 == 0 || n == b) {
                cnt2++;
                b = n;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for (int n: nums) {
            if (n == a)   cnt1++;
            else if (n == b) cnt2++;
        }

        List<Integer> result = new ArrayList<Integer>();
        if (cnt1 > nums.length/3)   result.add(a);
        if (cnt2 > nums.length/3)   result.add(b);
        return result;
    }
}