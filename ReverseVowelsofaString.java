/*Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".*/

public class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() <= 1) {
            return s;
        }
        char[] str = s.toCharArray();
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            while (i < j && !isVowel(str[i])) i++;
            while (i < j && !isVowel(str[j])) j--;
            if (i <= j) swap(str, i, j);
        }
        return new String(str);
    }
    private boolean isVowel(char ch) {
        char c = Character.toLowerCase(ch);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}