/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].*/

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
    public List<Integer> preorderTraversal(TreeNode node) {
	    List<Integer> list = new LinkedList<Integer>();
	    Stack<TreeNode> rights = new Stack<TreeNode>();
	    while(node != null) {
		    list.add(node.val);
		    if (node.right != null) {
			    rights.push(node.right);
		    }
		    node = node.left;
		    if (node == null && !rights.isEmpty()) {
			    node = rights.pop();
		    }
	    }
        return list;
    }
}