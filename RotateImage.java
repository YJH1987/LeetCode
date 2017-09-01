/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?*/

// solution 1
public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - 1 - j];
                matrix[i][col - 1 - j] = temp;
            }
        }
    }
}

// solution 2
public class Solution {

    public void rotateSwap(int[][] matrix, int i, int j, int len) {
        int temp1 = matrix[i][j];

        matrix[i][j] = matrix[len - 1 - j][i];
        matrix[len - 1 - j][i] = matrix[len - i - 1][len - j - 1];
        matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
        matrix[j][len - i - 1] = temp1;
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length, i, j;
        //int range = (len & 2) == 1 ? len / 2 + 1 : len / 2;

        for (i = 0; i < (len + 1) / 2; i++) {
            for (j = 0; j < len / 2; j++)
                rotateSwap(matrix, i, j, len);
        }
    }
}