public class SingleNumber2 {
    public int singleNumber(int[] A) {
        int ones = 0;  
   int twos = 0;  
   int not_threes, x;  

   for (int i=0; i<A.length; ++i) {  
            x =  A[i];  
            twos |= ones & x;  
            ones ^= x;  
            not_threes = ~(ones & twos);  
            ones &= not_threes;  
            twos &= not_threes;  
   }
   return ones;
   }
}

