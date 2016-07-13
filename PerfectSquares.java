/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.*/

public class Solution {
    public int numSquares(int n) {
        if (Math.pow((int) Math.sqrt(n), 2) == n) {
            return 1;
        }
        while (n % 4 == 0) {
            n = n / 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        if (n % 2 == 0) {
            n = n / 2;
        }
        if (n % 4 == 3) {
            return 3;
        }
        return helper(n, 3);
    }

    private int helper(int num, int start) {
        int sq = (int) Math.sqrt(num);
        for (int i = start; i < sq; i = i + 4) {
            if (num % i == 0) {
                int isq = i * i;
                if (num % isq == 0) {
                    return helper(num / isq, i);
                }
                return 3;
            }
        }
        return 2;
    }
}