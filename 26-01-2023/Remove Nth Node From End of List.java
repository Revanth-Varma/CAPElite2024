/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        size = size-n;
        if(size==0) return head.next;
        curr = head;
        for(int i=1;i<size;i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
