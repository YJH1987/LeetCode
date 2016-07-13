// Solution 1
public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
		    return null;
	    }
 
	    if (s.length() == 1) {
		    return s;
	    }
 
	    String longest = s.substring(0, 1);
	    for (int i = 0; i < s.length(); i++) {
		    // get longest palindrome with center of i
		    String tmp = expand(s, i, i);
		    if (tmp.length() > longest.length()) {
			    longest = tmp;
		    }
 
		    // get longest palindrome with center of i, i+1
		    tmp = expand(s, i, i + 1);
		    if (tmp.length() > longest.length()) {
			    longest = tmp;
		    }
	    }
 
	    return longest;
    }
    
    public String expand(String s, int begin, int end) {
	    while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
		    begin--;
		    end++;
	    }
	    return s.substring(begin + 1, end);
    }
}

// Solution 2
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++; 
        }
        return R - L - 1;
    }
}