/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (s.length() == 0) {
            ret.add(new ArrayList<String>());
            return ret;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (isP(s.substring(0, i))) {
                for (List<String> r : partition(s.substring(i))) {
                    r.add(0, s.substring(0, i));
                    ret.add(r);
                }
            }
        }
        return ret;
    }

    private boolean isP(String s) {
        if (s.equals("")) return true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}