// Solution 1
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); 
        map.put('V', 5); 
        map.put('X', 10);
        map.put('L', 50); 
        map.put('C', 100); 
        map.put('D', 500);
        map.put('M', 1000);
        
        int prev = 0, total = 0;
        for (char c : s.toCharArray()) {
            int curr = map.get(c);
            total += (curr > prev) ? (curr - 2 * prev) : curr;
            prev = curr;
        }
        
        return total;
    }
}

// Solution 2
public class Solution {
    public int romanToInt(String s) {
        /*
            I 1
            V 5
            X 10
            L 50
            C 100
            D 500
            M 1000
        
            CM CD XC XL IX IV
        */
        int r = 0;
        s = s.toUpperCase();
        for(int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char d = s.charAt(i+1);
            switch(c) {
                case 'I': if(d!='X'&&d!='V') r+=1; else r-=1; break;
                case 'V': r+=5; break;
                case 'X': if(d!='C'&&d!='L') r+=10; else r-=10; break;
                case 'L': r+=50; break;
                case 'C': if(d!='M'&&d!='D') r+=100; else r-=100; break;
                case 'D': r+=500; break;
                case 'M': r+=1000; break;
            }
        }
        switch(s.charAt(s.length()-1)) {
            case 'I': r+=1; break;
            case 'V': r+=5; break;
            case 'X': r+=10; break;
            case 'L': r+=50; break;
            case 'C': r+=100; break;
            case 'D': r+=500; break;
            case 'M': r+=1000; break;
        }
        return r;
    }
}
