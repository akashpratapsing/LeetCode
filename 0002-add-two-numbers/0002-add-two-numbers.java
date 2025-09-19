/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode num1 = l1, num2 = l2;
        int carry = 0;

        while (num1 != null || num2 != null || carry != 0){

            int a = (num1 != null) ? num1.val : 0;
            int b = (num2 != null) ? num2.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            num1 = (num1 != null) ? num1.next : null;
            num2 = (num2 != null) ? num2.next : null;
            
        }
      return dummy.next;
    }
}