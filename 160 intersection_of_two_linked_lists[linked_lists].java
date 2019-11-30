/*
160. Intersection of Two Linked Lists
---
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

    A:          a1 → a2
                         ↘
                            c1 → c2 → c3
                         ↗            
    B:     b1 → b2 → b3
begin to intersect at node c1.
---
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

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
    /*
    You can prove that: say A length = a + c, B length = b + c, after switching pointer,
    pointer A will move another b + c steps, pointer B will move a + c more steps,
    since a + c + b + c = b + c + a + c, it does not matter what value c is.
    Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        // In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node
        // In the second iteration, we will move two pointers until they points to the same node
        // So if two linkedlist intersects, the meeting point in second iteration must be the intersection point. 
        // If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null
        while (a != b) {
            if (a != null)
                a = a.next;
            else
                a = headB;
            
            if (b != null)
                b = b.next;
            else
                b = headA;
        }
        
        return a;
    }
}

