/*Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].*/

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (dict.contains(s.substring(i))) {
                break;
            } else {
                if (i == 0) {
                    return result;
                }
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                List<String> str = wordBreak(s.substring(i + 1, s.length()), dict);
                if (str.size() != 0) {
                    for (Iterator<String> it = str.iterator(); it.hasNext();) {
                        result.add(s.substring(0, i + 1) + " " + it.next());
                    }
                }
            }
        }
        if (dict.contains(s)) result.add(s);
        return result;
    }
}