/*
206. Reverse Linked List
---
Reverse a singly linked list iteratively.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
      if(head == null) return head;
      
      ListNode next = head.next;
      head.next = null;
        
      while(next != null){
          ListNode temp = next.next;
          next.next = head;
          head = next;
          next = temp;
        }
      return head;
    }
}
