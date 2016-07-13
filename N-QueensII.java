/*Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.*/

public class Solution {
    public int totalNQueens(int n) {
        int[] maindiag = new int[2 * n];
        int[] antidiag = new int[2 * n];
        int[] col = new int[n];

        recursive(maindiag, antidiag, col, 0);
        return total;
    }

    int total = 0;

    public void recursive(int[] maindiag, int[] antidiag, int[] columns, int i) {
        int size = columns.length;
        if (i == size) {
            total++;
            return;
        }

        for (int j = 0; j < size; j++) {
            boolean ok = (columns[j] == 0 && maindiag[i + j] == 0 && antidiag[i - j + size] == 0);
            if (!ok) continue;
            columns[j] = maindiag[i + j] = antidiag[i - j + size] = 1;
            recursive(maindiag, antidiag, columns, i + 1);
            columns[j] = maindiag[i + j] = antidiag[i - j + size] = 0;
        }
    }
}