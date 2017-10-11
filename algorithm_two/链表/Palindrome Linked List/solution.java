class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //获取中间结点
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        slow = resvere(slow);
        fast = head;
        //判断条件是slow是否为空
        while(slow!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    //链表的转置有很多方法 1.借助第三个结点，指针变换 2.递归 3.插入结点
        public ListNode resvere(ListNode head){
        ListNode pre = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
            return pre;
    }
}