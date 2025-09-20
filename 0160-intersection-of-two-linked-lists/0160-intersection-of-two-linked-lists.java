/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode first = headA, sec = headB;
        int len1 = 0, len2 = 0;
        
        while (first != null){
            len1++;
            first = first.next;
        }
        while (sec != null){
            len2++;
            sec = sec.next;
        }
        
        // int diff = Math.abs(len1 - len2);
        if (len1 < len2){
            return collision(headB, headA, len2 - len1);
        }else {
            return collision(headA, headB, len1 - len2);
        }
    }

    public ListNode collision(ListNode headA, ListNode headB, int n){

        ListNode first = headA, sec = headB;
        while (n-- > 0){
            first = first.next;
        }

        while (first != sec){
            first = first.next;
            sec = sec.next;
        }
        return first;
    }
}