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

// Solution 2
public class Solution {
    public String reverseWords(String s) {
        
        s = s.trim();
        
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        
        boolean afterSpace = false;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                if(!afterSpace) {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                    afterSpace = true;
                }
            } else {
                stack.push(c);
                afterSpace = false;
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.reverse();
        return sb.toString();
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