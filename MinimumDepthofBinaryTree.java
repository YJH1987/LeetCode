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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        if(root.left==null) return minDepth(root.right) + 1;
        if(root.right==null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}

-----------------------------------------------------------------------------------------

import java.util.LinkedList;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {return 0;}
	LinkedList<TreeNode> nodes  = new LinkedList<TreeNode>();
	LinkedList<Integer> counts = new LinkedList<Integer>();
	nodes.add(root);
	counts.add(1);

	while (!nodes.isEmpty()) {
	    TreeNode curr = nodes.remove();
	    int count = counts.remove();
	    
	    if(curr.left != null) {
		nodes.add(curr.left);
		counts.add(count + 1);
	    }

	    if(curr.right != null) {
		nodes.add(curr.right);
		counts.add(count + 1);
	    }

	    if(curr.left == null && curr.right == null) {
		return count;
	    }
	}	     
	return 0;
    }
}
