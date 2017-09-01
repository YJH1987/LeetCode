/*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
         if(head==null||head.next==null) return head;
         ListNode cur1=head, cur2=head.next;
         
         while(cur2 != null) {
             if(cur2.val != cur1.val) {
                 cur1.next = cur2;
                 cur1 = cur1.next;
             }
             cur2 = cur2.next;
         }
         cur1.next = null;
         return head;
    }
}
