/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2*/

public class Solution {
    public List<Integer> grayCode(int n) {
        /*
        0 1
        00 01 11 10
        000 001 011 010 110 111 101 100
        0000 0001 0011 0010 0110 0111 0101 0100 1100 1101 1111 1110 1010 1011 1001 1000
        */
        List<Integer> r = new ArrayList<Integer>();
        if (n < 0) return r;
        if (n == 0) {
            r.add(0);
            return r;
        }
        r.add(0);
        r.add(1);
        for (int i = 1; i < n; i++) {
            int len = r.size();
            for (int j = len - 1; j >= 0; j--) {
                r.add((1 << i) + r.get(j));
            }
        }
        return r;
    }
}