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
        ListNode temp = head;
        int size = 0;

        while(temp != null){
            temp = temp.next;
            size++;
        }

        int del = size - n;
        if(del == 0) return head.next;

        ListNode curr = head;

        int i = 0;
        while(i < del - 1){
            curr = curr.next;
            i++;
        }

        curr.next = curr.next.next;

        return head;
    }
}
