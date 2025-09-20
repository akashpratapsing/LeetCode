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

        if (headA == null || headB == null){
            return null;
        }

        ListNode first = headA, sec = headB;
        while (first != sec){
            first = first.next;
            sec = sec.next;
            if (first == sec) return first;
            if (first == null) first = headB;
            if (sec == null) sec = headA;
        }
        return first;
    }

}