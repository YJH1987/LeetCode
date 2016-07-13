// Solution 1
public class Solution {
    public int singleNumber(int[] A) {
        int r = 0;
        for(int i=0; i<A.length; i++) {
            r ^= A[i];
        }
        return r;
    }
}

// Solution 2
public class Solution {
    public int singleNumber(int[] A) {
        int num = 0;
        for (int x : A) {
            num ^= x;
        }
        return num;
    } 
}