/*Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map1 = new char[256], map2 = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!this.map(a, b, map1) || !this.map(b, a, map2)) {
                return false;
            }
        }
        return true;
    }

    private boolean map(char a, char b, char[] map) {
        if (map[a] == 0) {
            map[a] = b;
        }
        return map[a] == b;
    }
}