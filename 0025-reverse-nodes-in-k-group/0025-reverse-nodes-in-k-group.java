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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head, prev = null;
        while (temp != null){
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null){
                if (prev != null){
                    prev.next = temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if (temp == head){
                head = kthNode;
            }else {
                prev.next = kthNode;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode getKthNode(ListNode head, int k){
        k--;
        ListNode curr = head;
        while (curr != null && k-- > 0){
            curr = curr.next;
        }
        return curr;
    }
    public ListNode reverse(ListNode head){

        ListNode curr = head, prev = null, next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}