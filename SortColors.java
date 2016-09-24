/*Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.*/

public class Solution {
    public void sortColors(int[] A) {
        int[] countTable = new int[3];
        for(int i = 0; i < A.length; i++) {
            countTable[A[i]]++;
        }
        int j = 0;
        for(int i = 0; i < countTable[0]; i++) {
            A[j++] = 0;
        }
        for(int i = 0; i < countTable[1]; i++) {
            A[j++] = 1;
        }
        for(int i = 0; i < countTable[2]; i++) {
            A[j++] = 2;
        }
    }
}
