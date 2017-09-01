/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.*/

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
        ListNode prev = new ListNode(0);
        prev.next = head;
        head = prev;
        ListNode p1 = head;
        while(p1.next != null) {// p1 = null
            ListNode p2 = p1.next;
            while(p2.next != null && p2.val == p2.next.val) {
                p2 = p2.next;
            }
            if(p1.next !=  p2) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return head.next;  
    }
}