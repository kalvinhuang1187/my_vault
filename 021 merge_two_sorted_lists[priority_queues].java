/*
21. Merge Two Sorted Lists
---
Merge two sorted linked lists and return it as a new list. The new list should be made
by splicing together the nodes of the first two lists.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergedLinkedLists{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(0);
        ListNode ptr = mergedList;
        
        if (l1 == null && l2 == null)
            return mergedList.next;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ptr.next = l1;
                ptr = ptr.next;
                l1 = l1.next;
            }
            else {
                ptr.next = l2;
                ptr = ptr.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) 
            ptr.next = l2;
        else
            ptr.next = l1;
        
        return mergedList.next;
    }
}

