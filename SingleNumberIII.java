/*Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?*/

public class Solution {
    public int[] singleNumber(int[] A) {
        int xor = 0;
        for (int a : A) {
            xor = xor ^ a;
        }
        //xor = re1 ^ re2
        //as re1 != re2 thus xor != 0 
        int mask = 1;
        while ((mask & xor) == 0)
            //find the rightmost bit at position P such that xor@P == 1, we know that re1@P != re2@P. Set the mask = 1(@P)000...
            mask = mask << 1;
        //divide the array elements into two paritions according to A[i]@P == 0 / 1
        int xor1 = 0, xor2 = 0; 
        for (int a : A) {
            //Let's suppose re1@P == 0, then xor1 = [xor each (A[i]@P == 1)] = re1
            if ((mask & a) == 0) {  
                xor1 = xor1 ^ a;
            } else {
                //As re2@P == 0, then [xor each (A[i]@P == 0)] = re2
                xor2 = xor2 ^ a;
            }
        }
        
        int[] result = new int[2];
        result[0] = xor1;
        result[1] = xor2;
        return result;
    }
}