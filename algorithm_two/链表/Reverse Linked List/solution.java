/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//有点向servlet filter chain的机制
class Solution {
    public ListNode reverseList(ListNode head) {
         if(head == null || head.next == null){
             return head;
         }
        ListNode next = head.next;
        ListNode newNode = reverseList(next);
        next.next  = head;
        head.next = null;
        return newNode;
    }
}