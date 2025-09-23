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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null){
            return head;
        }
        int count = 1;
        ListNode tail = head;
        while (tail.next != null){
            count++;
            tail = tail.next;
        }
        
        if (k % count == 0) return head;

        tail.next = head;
        k %= count;
        count = count - (k + 1);
        ListNode kthNode = head;
        while (count-- > 0){
            kthNode = kthNode.next;
        }
        head = kthNode.next;
        kthNode.next = null;
        return head;
    }
}