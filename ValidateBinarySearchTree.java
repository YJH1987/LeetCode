/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left) || !isValidBST(root.right)) return false;
        if (root.left != null) {
            TreeNode pred = root.left;
            while (pred.right != null) pred = pred.right;
            if (root.val <= pred.val) return false;
        }
        if (root.right != null) {
            TreeNode succ = root.right;
            while (succ.left != null) succ = succ.left;
            if (root.val >= succ.val) return false;
        }
        return true;
    }
}

// Solution 2
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode p, Integer low, Integer high) {
        if (p == null) {
            return true;
        }
        
        return (low == null || p.val > low)
            && (high == null || p.val < high)
            && isValid(p.left, low, p.val)
            && isValid(p.right, p.val, high);
    }
}