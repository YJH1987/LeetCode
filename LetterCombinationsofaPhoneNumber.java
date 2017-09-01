/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.*/

// solution 1
import java.util.*;
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> r = new ArrayList<String>();
        if (digits.length() == 0) {
            r.add("");
            return r;
        }
        HashMap<String, String> dic = new HashMap<String,String>();
        dic.put("2", "abc"); 
        dic.put("3", "def"); 
        dic.put("4", "ghi"); 
        dic.put("5", "jkl");
        dic.put("6", "mno"); 
        dic.put("7", "pqrs"); 
        dic.put("8", "tuv"); 
        dic.put("9", "wxyz");
        
        for (int i = 0; i < digits.length(); i++) {
            if (!dic.keySet().contains(String.valueOf(digits.charAt(i)))) return r;
        }
        
        String s0 = dic.get(digits.substring(0,1));
        for (int i = 0; i < s0.length(); i++) {
            for (String s : letterCombinations(digits.substring(1))) {
                r.add(String.valueOf(s0.charAt(i)) + s);
            }
        }
        return r;
    }
}

// solution 2
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String> ();
        if (digits.length() == 0) {
            return ans;
        }
        String[] mapping = new String[] {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s: mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}