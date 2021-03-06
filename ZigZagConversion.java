// Solution 1:
public class Solution {
    public String convert(String s, int nRows) {
        /*
            def convert(self, s, nRows):
                if nRows<=1:
                    return s
                r=s[::(2*nRows-2)]
                for i in range(1,nRows-1):
                    a=s[i::(2*nRows-2)]
                    b=s[(2*nRows-2-i)::(2*nRows-2)]
                    r+=''.join(a[k]+b[k] for k in range(len(b)))+a[len(b):]
                r+=s[(nRows-1)::(2*nRows-2)]
                return r
        */
        if(nRows <= 1) return s;
        StringBuilder r = new StringBuilder();
        for(int i = 0; i<s.length(); i+=2*nRows-2) r.append(s.charAt(i));
        for(int i = 1; i<nRows - 1; i++) {
            StringBuilder a = new StringBuilder();
            for(int j = i; j<s.length(); j+=2*nRows-2) a.append(s.charAt(j));
            StringBuilder b = new StringBuilder();
            for(int j = 2*nRows-2-i; j<s.length(); j+=2*nRows-2) b.append(s.charAt(j));
            String as = a.toString(), bs = b.toString();
            for(int j=0; j<bs.length(); j++) { 
                r.append(as.charAt(j));
                r.append(bs.charAt(j));
            }
            r.append(as.substring(bs.length()));
        }
        for(int i = nRows-1; i<s.length(); i+=2*nRows-2) r.append(s.charAt(i));
        return r.toString();
    }
}

// Solution 2:
public class Solution {
    public String convert(String s, int numRows) {
        ArrayList<Character>[] rows = (ArrayList<Character>[]) new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<Character>();
        }
        
        int n = s.length();
        for (int i = 0; i < n; ) {
            for (int j = 0; j < numRows && i < n; j++, i++) {
                rows[j].add(s.charAt(i));
            }
            
            for (int j = numRows - 2; j > 0 && i < n; j--, i++) {
                rows[j].add(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder(n);
        for (int row = 0; row < numRows; row++) {
            for (int j = 0, rowLen = rows[row].size(); j < rowLen; j++) {
                sb.append(rows[row].get(j));
            }
        }
        return sb.toString();
    }
}