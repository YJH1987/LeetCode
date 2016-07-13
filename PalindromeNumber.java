// Determine whether an integer is a palindrome. Do this without extra space.

public class PalindromeNumber {
    public boolean isPalindromeNumber(int x) {
	if (x < 0) return false;
	int div = 1;
	while (x / div > 10) {
	    div *= 10;
	}
	
	while (x > 0) {
	    int left = x / div;
	    int right = x % 10;
	    if (left != right) return false;

	    x -= left*div;
	    x /= 10;
	    div /= 100;
	}
	return true;
    }
}

// test case: 12321
// test case: 1001 returns the wrong answer