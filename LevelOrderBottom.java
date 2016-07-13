import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBottom {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        
        Queue<TreeNode>[] queue =  new LinkedList[2];
        queue[0] = new LinkedList<TreeNode>();
        queue[1] = new LinkedList<TreeNode>();
        int index = 0;
        
        // the following is the ordinary BFS
        queue[index].add(root);
        TreeNode tmp;
        // if both stack are not empty
        while( (!queue[index].isEmpty()) || (!queue[1-index].isEmpty())){
        ArrayList<Integer> level = new ArrayList<Integer>();
            while(!queue[index].isEmpty()){
                tmp = queue[index].remove();
                level.add(tmp.val); // add current node into the list
                // add left into another list
                if(tmp.left != null){
                     queue[1-index].add(tmp.left);
                }
                if(tmp.right != null){
                     queue[1-index].add(tmp.right);
                }
            }
            result.add(0,level);  // add current level of nodes into returned result
            // after above while (), current level is complete, and the stack[index] is empty
            index = 1 - index;
        }
        return result;
    }
}
