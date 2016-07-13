import java.util.ArrayList;

public class Pascal {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> pascal = new  ArrayList<ArrayList<Integer>>();
        if(numRows == 0) return new ArrayList<ArrayList<Integer>>();
        
        for(int i=1; i<=numRows; i++){
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for(int row=1; row<=i; row++){
                if(row==1) {
                numbers.add(0, 1);
            }else if(row==i){
                numbers.add(row-1,1);
            }else{
            	int first = pascal.get(i-2).get(row-1);
            	int second = pascal.get(i-2).get(row-2);
                numbers.add(row-1, (first+second));
            }
        }
        pascal.add(numbers);
    }
    return pascal;
    }
}
