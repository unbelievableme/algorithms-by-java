/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//my solution useing O(n) extra space
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet addr = new HashSet();
        while(head!=null){
           boolean ls = addr.add(head.next);
            if(ls == false) return true;
            head = head.next;
        }
        return false;
    }
}
//better solution O（1）space
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode a = head;
        ListNode b = head;
        //注意循环条件，由于b跑的比较快，因此通过b的next来决定
        while(b.next!=null&&b.next.next!=null){
            a = a.next;
            b = b.next.next;
            if(a == b)return true;
        }
        return false;
    }
}