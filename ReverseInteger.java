//Solution 1
public class ReverseInteger {
	public int reverse(int x) {
		int reversedNum = 0;
		
		while (x != 0)
		{
			reversedNum = reversedNum * 10 + x % 10;
			x = x / 10;   
		}
		
		if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
		{
			throw new IllegalArgumentException();
		}
		return reversedNum;
	}
}

//Solution 2
public class Solution {
    public int reverse(int x) {
        /*
            0xffffffff
            trailing 0s
            overflow
        */
        
        while(x % 10 == 0 && x != 0) x /= 10;
        int sign = x < 0 ? -1 : 1;
        long y = (long)x;
        y *= sign;
        StringBuilder sb = new StringBuilder(String.valueOf(y));
        sb.reverse();
        y = sign * Long.valueOf(sb.toString());
        y = y < 0x80000000 ? 0x80000000 : y;
        y = y > 0x7fffffff ? 0x7fffffff : y;
        return (int)y;
    }
}