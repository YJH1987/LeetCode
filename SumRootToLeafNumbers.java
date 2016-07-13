public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int cur = 0;
        sum = 0;
        dfs(root, cur);
        return sum;
    }

    public void dfs(TreeNode root, int cur) {
        if (root == null) return;
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += cur;
            return;
        }

        dfs(root.left, cur);
        dfs(root.right, cur);

        return;
    }
}

----------------------------------------------------------------------

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Solution {
    public int sumNumbers(TreeNode root) {
        /*
            sum=0
            stack.push root
            while stack not empty:
                node = stack.pop
                if node is leaf:
                    sum += node.val
                else if node.left!=null:
                    node.left.val += 10*node.val
                    stack.push node.left
                else if node.right!=null:
                    node.right.val += 10*node.val
                    stack.push node.right
            stack.push root
            while stack not empty:
                node = stack.pop
                node.val %= 10
                if node.left!=null:
                    stack.push node.left
                if node.right!=null:
                    stack.push node.right
            return sum
        */
        if (root == null) return 0;
        int sum = 0;
        ArrayDeque < TreeNode > stack = new ArrayDeque < TreeNode > ();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                node.left.val += 10 * node.val;
                stack.push(node.left);
            }
            if (node.right != null) {
                node.right.val += 10 * node.val;
                stack.push(node.right);
            }
            if (node.left == null && node.right == null) sum += node.val;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.val %= 10;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return sum;
    }
}