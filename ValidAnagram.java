/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?*/

// Solution 1
public class Solution {
    public boolean isAnagram(String s, String t) {

        int count1[] = new int[26];
        int count2[] = new int[26];

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            count1[(s.charAt(i) - 'a')]++;
            count2[(t.charAt(i) - 'a')]++;
        }

        if (Arrays.equals(count1, count2))
            return true;
        else
            return false;
    }
}

// Solution 2
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        
        Arrays.sort(s_char);
        Arrays.sort(t_char);
        
        s = new String(s_char);
        t = new String(t_char);
        
        return s.equals(t);
    }
}