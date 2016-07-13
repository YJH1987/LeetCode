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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

---------------------------------------------------------------

import java.util.Stack;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        if (p == null && q != null)
            return false;

        while (p != null || stack1.size() != 0) {
            if (p != null) {
                if (q == null || q.val != p.val)
                    return false;
                stack1.push(p);
                stack2.push(q);
                p = p.left;
                q = q.left;
            } else {
                if (stack1.size() != stack2.size())
                    return false;
                p = stack1.pop();
                q = stack2.pop();
                p = p.right;
                q = q.right;

                if (p == null && q != null)
                    return false;
            }
        }

        return true;
    }
}
