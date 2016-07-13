// Solution 1
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }
}

// Solution 2
import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            def lengthOfLongestSubstring(self, s):
                d={}
                start=0
                ret=0
                for i in range(len(s)):
                    c=s[i]
                    if d.__contains__(c) and start<d[c]+1:
                        start=d[c]+1
                    ret = max(ret, i-start+1)
                    d[c]=i
                return ret
        */
        Map<Character,Integer> d = new HashMap<Character,Integer>();
        int start=0,ret=0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(d.containsKey(c) && start<d.get(c)+1) start=d.get(c)+1;
            ret = Math.max(ret, i-start+1);
            d.put(c,i);
        }
        return ret;
    }
}
