public class SymmetricBT {
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null || right == null) {
            return false;
        }
        
        boolean checkLeft = isSymmetric(left.left, right.right);
        boolean checkRight = isSymmetric(left.right, right.left);
        
        if(checkLeft && checkRight && left.val == right.val) {
            return true;
        } else {
            return false;
        }
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
