// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
// If the last word does not exist, return 0.

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0, last = s.length() - 1;
	while (last >= 0 && s.charAt(last) == ' ') last--;
	while (last >= 0 && s.charAt(last--) != ' ') ++len;
	return len;
    }
}

-------------------------------------------------------------------------------

public class Solution {
    public int lengthOfLastWord(String s) {
        /*
            i=s.length()-1
            while i>=0 and s.charAt(i) == ' ':
                i--
            len=0
            while i>=0 and s.charAt(i) != ' ':
                i--
                len++
            return len
            
            test:
            ''
            ' '
            '   '
            '   ss '
            'ss    '
            's'
            ' asd as  assadf  '
            'asdasdasdasd'
        */
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' ') i--;
        int len = 0;
        while(i>=0 && s.charAt(i) != ' ') {
            i--;
            len++;
        }
        return len;
    }
}
