/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Solution 1
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        root.left = mirror(root.left);
        boolean result = isSameTree(root.left, root.right);
        root.left = mirror(root.left);
        return result;
    }
    private TreeNode mirror(TreeNode root) {
        if(root==null) return root;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        root.left = mirror(root.left);
        root.right = mirror(root.right);
        return root;
    }
    private boolean isSameTree(TreeNode a, TreeNode b) {
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}

// Solution 2
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack_p = new Stack<>();
        Stack<TreeNode> stack_q = new Stack<>();
        if (root != null)
            stack_p.push(root);
        stack_q.push(root);
        while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
            TreeNode pn = stack_p.pop();
            TreeNode qn = stack_q.pop();
            if (pn.val != qn.val) return false;
            if (pn.left != null) stack_p.push(pn.left);
            if (qn.right != null) stack_q.push(qn.right);
            if (stack_p.size() != stack_q.size()) return false;
            if (pn.right != null) stack_p.push(pn.right);
            if (qn.left != null) stack_q.push(qn.left);
            if (stack_p.size() != stack_q.size()) return false;

        }
        return stack_p.size() == stack_q.size();
    }
}