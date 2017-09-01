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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}


// Solution 2
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

// Solution 3
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
	     Stack<TreeNode> stack_p = new Stack<>();       
	     Stack<TreeNode> stack_q = new Stack<>();
	     if (p != null) stack_p.push( p ) ;
	     if (q != null) stack_q.push( q ) ;
	     while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
	    	 TreeNode pn = stack_p.pop() ;
	    	 TreeNode qn = stack_q.pop() ;	    	
	    	 if (pn.val != qn.val) return false ;
	    	 if (pn.left != null) stack_p.push(pn.left) ;	    	 	    	 
	    	 if (qn.left != null) stack_q.push(qn.left) ;
	    	 if (stack_p.size() != stack_q.size()) return false ;
	    	 if (pn.right != null) stack_p.push(pn.right) ;
	    	 if (qn.right != null) stack_q.push(qn.right) ;
	    	 if (stack_p.size() != stack_q.size()) return false ;
	    	 
	     }		     
	     return stack_p.size() == stack_q.size() ;	 
	 }
}