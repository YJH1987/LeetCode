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
        if(root==null) return true;
        if(!isValidBST(root.left) || !isValidBST(root.right)) return false;
        if(root.left!=null) {
            TreeNode pred=root.left;
            while(pred.right!=null) pred=pred.right;
            if(root.val<=pred.val) return false;
        }
        if(root.right!=null) {
            TreeNode succ=root.right;
            while(succ.left!=null) succ=succ.left;
            if(root.val>=succ.val) return false;
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