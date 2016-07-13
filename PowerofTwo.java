/*Given an integer, write a function to determine if it is a power of two.*/

public class Solution {
    public boolean isPowerOfTwo(int n) {

        if (n < 1) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1 ? true : false;
    }
}