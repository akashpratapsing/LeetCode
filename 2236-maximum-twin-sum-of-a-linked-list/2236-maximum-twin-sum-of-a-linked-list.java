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
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        // Finding middle node
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reversing other half
        ListNode next, prev = null;
        while(slow != null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // Calculating max twin sum
        int maxVal = 0;
        while (prev != null){
            maxVal = Math.max(maxVal, prev.val + head.val);
            prev = prev.next;
            head = head.next;
        }

        return maxVal;


    }
}