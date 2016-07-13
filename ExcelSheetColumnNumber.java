/*Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 */

public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int result = s.charAt(0) - 'A' + 1;
        for (int i = 1; i < len; i++) {
            int temp = s.charAt(i) - 'A' + 1;
            result =  temp + result * 26;
        }
        return result;
    }
}