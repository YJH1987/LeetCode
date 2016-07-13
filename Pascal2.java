import java.util.ArrayList;

public class Pascal2 {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> row = null;  
		for (int i=0; i<=rowIndex; ++i) {  
			ArrayList<Integer> preRow = row;  
			row = new ArrayList<Integer>();  
			if (i==0) {
				row.add(1);  
			} else {  
				for (int j=0; j<=i; ++j) {  
					int val = ((j > 0) ? preRow.get(j-1) : 0)  
							+ ((j < preRow.size()) ? preRow.get(j) : 0);  
					row.add(val);  
				}  
			}  
		}  
		return row;  
	} 
 }
