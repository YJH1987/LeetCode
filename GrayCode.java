/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2*/

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<Integer>();
        results.add(0);
        
        for (int i = 0; i < n; ++i) {
            int flipper = 1 << i;
            for (int j = results.size() - 1; j >= 0; --j) {
                results.add(results.get(j) | flipper);
            } 
        }
        return results;  
    }
}