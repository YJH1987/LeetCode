/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
 
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        /*
            T(N)=O(N)+2T(N/2) ==> O(nlog(n)) O(log(n))
            
            c=head
            l=0
            while c!=null:
                c=c.next
                l++
            if l==0: return null
            if l==1: return new TreeNode(head.val)
            c=head
            i=l/2
            while i-->1:
                c=c.next
            root = new TreeNode(c.next.val)
            root.right=sortedListToBST(c.next.next)
            c.next=null
            root.left=sortedListToBST(head)
            return root
            
            T(N)=2T(N/2)+O(1) ==> O(n) O(n)
            
            arr <= head
            
            def f(arr, i, j):
                if j<=i: return null
                if j==i+1: return new ...
                mid = (i+j)/2
                root = new arr[mid]
                root.left=f(arr, i, mid)
                root.right=f(arr, mid+1, j)
                return root
                
        */
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ListNode c = head;
        while(c!=null) {
            arr.add(c.val);
            c = c.next;
        }
        return arrToBst(arr, 0, arr.size()-1);
    }
    
    private TreeNode arrToBst(ArrayList<Integer> arr, int i, int j) {
        if(j < i) return null;
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = arrToBst(arr, i, mid-1);
        root.right = arrToBst(arr, mid+1, j);
        return root;
    }
}

// Solution 2
public class Solution {
    private ListNode list;
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(mid + 1, end);
        return parent;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        
        list = head;
        return sortedListToBST(0, n - 1);
    }
}