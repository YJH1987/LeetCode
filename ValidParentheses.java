/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/

// Solution 1
import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        if(s==null) return false;
        if(s.length()==0) return true;
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{') stack.push(c);
            else if(c==')') {
                if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                else return false;
            }
            else if(c==']') {
                if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
                else return false;
            }
            else if(c=='}') {
                if(!stack.isEmpty() && stack.peek()=='{') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}

// Solution 2
public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(stack.pop()) != c) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}