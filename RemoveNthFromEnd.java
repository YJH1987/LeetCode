// given a linked list, remove the nth node from the end of list and return its head.

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, prev = head;
        while(n-- > 0) {
            cur = cur.next;
        }
        if (cur == null) 
            return head.next;
        while (cur.next != null) {
            cur = cur.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}