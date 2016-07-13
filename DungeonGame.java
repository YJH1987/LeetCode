/*The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2(K)	-3	3
-5	-10	1
10	30	-5(P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.*/

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
            // return 0 if dungeon does not exist
            if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
            int m = dungeon.length - 1, n = dungeon[0].length - 1;
            //make sure alive after rescue
            dungeon[m][n] = setHp(1 - dungeon[m][n]);

            //fill bottom row and right-most column
            for (int i = m - 1; i >= 0; i--)
                dungeon[i][n] = setHp(dungeon[i + 1][n] - dungeon[i][n]);
            for (int j = n - 1; j >= 0; j--)
                dungeon[m][j] = setHp(dungeon[m][j + 1] - dungeon[m][j]);

            //fill the rest
            for (int i = m - 1; i >= 0; i--)
                for (int j = n - 1; j >= 0; j--)
                //pick minimum hp needed after this cell
                    dungeon[i][j] = setHp(Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j]);

            return dungeon[0][0];
        }
        //if needed Hp is negative set hp to 1, otherwise positive
    private int setHp(int hp) { 
        return hp <= 0 ? 1 : hp;
    }
}