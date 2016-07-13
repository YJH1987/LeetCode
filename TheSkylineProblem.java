/*A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]*/

public class Solution {
    class KeyPoint {
        public int key;
        public int height;
        public KeyPoint next = null;

        public KeyPoint(int key, int height) {
            this.key = key;
            this.height = height;
        }

    }

    public static int[] getKeyPoint(int key, int height) {
        int[] kp = new int[2];
        kp[0] = key;
        kp[1] = height;
        return kp;
    }

    public List<int[]> getSkyline(int[][] buildings) {
        KeyPoint head = new KeyPoint(-1,0);
        KeyPoint prevKP = head;
        for (int[] building:buildings) {
            int l = building[0], r = building[1], h= building[2];
            // insert left point
            while (prevKP.next != null && prevKP.next.key <= l) prevKP = prevKP.next;
            int preHeight = prevKP.height;
            if (prevKP.key == l) prevKP.height = Math.max(prevKP.height, h);
            else if (prevKP.height < h) {
                KeyPoint next = prevKP.next;
                prevKP.next = new KeyPoint(l, h);
                prevKP = prevKP.next;
                prevKP.next = next;
            }
            // insert right point and update points in between
            KeyPoint prev = prevKP, cur = prevKP.next;
            while (cur != null && cur.key < r) {
                preHeight = cur.height;
                cur.height = Math.max(cur.height, h);
                if (cur.height == prev.height)
                    prev.next = cur.next;
                else
                    prev = cur;
                cur = cur.next;
            }
            if (prev.height != preHeight && prev.key != r && (cur == null || cur.key != r)) {
                KeyPoint next = prev.next;
                prev.next = new KeyPoint(r, preHeight);
                prev.next.next = next;
            }
        }
        // convert to List<int[]>
        List<int[]> list = new ArrayList<int[]>();
        KeyPoint prev = head, cur = head.next;
        while (cur != null) {
            if (cur.height != prev.height)
                list.add(getKeyPoint(cur.key, cur.height));
            prev = cur;
            cur = cur.next;
        }
        return list;
    }
}