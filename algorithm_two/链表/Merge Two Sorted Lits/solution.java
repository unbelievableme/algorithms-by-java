/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//构造一个头结点，简化步骤
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                result.next = l1;
                l1 = l1.next;
            }
            else{
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        result.next = (l1==null?l2:l1);
        return head.next;
    }
}