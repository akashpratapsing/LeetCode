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
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode curr = head;
        Stack<Integer> s = new Stack<>();
        while (curr != null){
            s.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while (curr != null){
            curr.val = s.pop();
            curr = curr.next;
        }
        return head;
    }
}