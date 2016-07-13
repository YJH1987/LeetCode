import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		char symbol[] = {'M','D','C','L','X','V','I'};
		int value[] = {1000,500,100,50,10,5,1};
		
		s = s.toUpperCase();
		if(s.length() == 0) return 0;
		
		for(int i = 0; i < symbol.length; i++)
		{
			int pos = s.indexOf(symbol[i]) ;
			
			if(pos >= 0)
				return value[i]-romanToInt(s.substring(0,pos))+romanToInt(s.substring(pos+1));
		}
		
		return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(romanToInt("CMXCIX"));
	}

}
