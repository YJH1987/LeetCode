/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".*/

// solution 1
import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        dp[s.length()-1] = dict.contains(s.substring(s.length()-1));
        for (int i=s.length()-2; i>=0; i--) {
            boolean found = false;
            for(int j=i+1; j<=s.length(); j++) {
                if(dict.contains(s.substring(i,j)) && dp[j]) {
                    found = true;
                    break;
                }
            }
            dp[i] = found;
        }
        return dp[0];
    }
}

// solution 2
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String str : wordDict) {
                if (str.length() <= i) {
                    if (f[i - str.length()]) {
                        if (s.substring(i - str.length(), i).equals(str)) {
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return f[s.length()];
    }
}