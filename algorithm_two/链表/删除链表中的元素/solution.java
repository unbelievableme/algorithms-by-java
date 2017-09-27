/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public  ListNode removeElements(ListNode head, int val) {
    	//处理第一个节点为空的情况，并且保证第一个节点的值不为val
        while(head!=null && head.val == val){
             head = head.next;
        }
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.next.val ==val){
                curr.next = curr.next.next;
            }
                else{
                    curr = curr.next;
                }
        }
        return head;
    }
}