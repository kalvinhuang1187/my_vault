/*
206. Reverse Linked List
---
Reverse a singly linked list.
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
        if (head == null || head.next == null)
            return head;
            
        ListNode nextNode = head.next;
        
        //just keeps track of last node/new head
        ListNode newHead = reverseList(nextNode);
        
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
    /*
    1 -> 2 -> 3
    ^ head
    
    head = 1
    nextNode = 2
    --- [return from recursion]
    newHead = 3
    3 -> 2 -> 1 -> null
    ^ newHead
         ^ nextNode
              ^ head
    
    newHead(2):
    head = 2
    nextNode = 3
    --- [return from recursion]
    newHead = 3
    3 -> 2 -> null
    ^ newHead/nextNode
         ^ head
    
    newHead(3):
    head = 3
    head.next == null (return 3)

    */
}

