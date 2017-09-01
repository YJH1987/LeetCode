/*Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".*/

// Solution 1
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
 
        // split to words by space
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}

// Solution 2 in-place solution
ppublic class Solution {
    public void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

// Solution 3
public String reverseWords(String s) { 
	StringBuilder reversed = new StringBuilder(); 
	int j = s.length();
	for (int i = s.length() - 1; i >= 0; i--) {
    	if (s.charAt(i) == ' ') {
    	    j = i;
    	} else if (i == 0 || s.charAt(i - 1) == ' ') {
        	if (reversed.length() != 0) {
        		reversed.append(' ');
        	}
        	reversed.append(s.substring(i, j));
		}
	}
   return reversed.toString();
}