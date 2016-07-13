/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new  ArrayList<List<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        dfs(res, tmp ,k , n, 1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int pos) {
        if (k == 0) {
            if (n == 0)
                res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = pos; i <= n / k && i < 10; i++) {
            tmp.add(i);
            dfs(res, tmp, k - 1, n - i, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}