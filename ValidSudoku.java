// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // rule1, column
        for (int i = 0; i < 9; i++) {
            HashSet<Character> test = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !test.add(board[j][i]))
                    return false;
            }
        }

        // rule2, row
        for (int i = 0; i < 9; i++) {
            HashSet<Character> test = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !test.add(board[i][j]))
                    return false;
            }
        }

        // rule3, sub-box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { // for each sub-box
                HashSet<Character> test = new HashSet<Character>();
                for (int m = i * 3; m < i * 3 + 3; m++) { //row
                    for (int n = j * 3; n < j * 3 + 3; n++) { //column
                        if (board[m][n] != '.' && !test.add(board[m][n]))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
            def isValidSudoku(self, board):
                for row in board:
                    r = [n for n in row if n!='.']
                    if len(r) != len(set(r)):
                        return False
                for j in range(9):
                    c = [board[i][j] for i in range(9) if board[i][j]!='.']
                    if len(c) != len(set(c)):
                        return False
                for i1 in range(3):
                    for j1 in range(3):
                        b = [board[i1*3+i2][j1*3+j2] for i2 in range(3) for j2 in range(3) if board[i1*3+i2][j1*3+j2]!='.']
                        if len(b) != len(set(b)):
                            return False
                return True
        */
        for (int i = 0; i < 9; i++) {
            ArrayList<Character> list = new ArrayList<Character>();
            for (int j = 0; j < 9; j++) {
                list.add(board[i][j]);
            }
            if (!check(list)) return false;
        }
        for (int j = 0; j < 9; j++) {
            ArrayList<Character> list = new ArrayList<Character>();
            for (int i = 0; i < 9; i++) {
                list.add(board[i][j]);
            }
            if (!check(list)) return false;
        }
        for (int i1 = 0; i1 < 3; i1++) {
            for (int j1 = 0; j1 < 3; j1++) {
                ArrayList<Character> list = new ArrayList<Character>();
                for (int i2 = 0; i2 < 3; i2++) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        list.add(board[i1 * 3 + i2][j1 * 3 + j2]);
                    }
                }
                if (!check(list)) return false;
            }
        }
        return true;
    }
    private boolean check(ArrayList<Character> list) {
        for (char c: list) {
            if (c != '.') {
                if (list.indexOf(c) != list.lastIndexOf(c)) return false;
            }
        }
        return true;
    }
}