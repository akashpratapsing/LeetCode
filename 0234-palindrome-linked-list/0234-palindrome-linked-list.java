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
    public boolean isPalindrome(ListNode head) {

        if (head.next == null){
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newNode = reverse(slow.next);
        ListNode first = head, sec = newNode;

        while(sec != null){
            if (first.val != sec.val){
                reverse(newNode);
                return false;
            }
            first = first.next;
            sec = sec.next;
        }
        reverse(newNode);
        return true;
    }

    public ListNode reverse(ListNode head){
        
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        while (head != null){
            ListNode front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }
}