/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

// Solution 1:
public class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;
        
        while (i < len1 || j < len2) {
            int tmp1 = 0, tmp2 = 0;
            
            while (i < len1 && version1.charAt(i) != '.') {
                tmp1 = tmp1 * 10 + version1.charAt(i++) - '0';
            }
            
            while (j < len2 && version2.charAt(j) != '.') {
                tmp2 = tmp2 * 10 + version2.charAt(j++) - '0';
            }
            
            if (tmp1 > tmp2) {
                return 1;
            } else if (tmp1 < tmp2) {
                return -1;
            } else {
                i++;
                j++;
            }
        }
        return 0;
    }
}

// Solution 2:
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}