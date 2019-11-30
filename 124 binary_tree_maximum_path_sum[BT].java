/*
124. Binary Tree Maximum Path Sum
---
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to
any node in the tree along the parent-child connections. The path must contain at least
one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BT {
    int maxValue;
    
    private int maxPathDown(TreeNode node) {
        if (node == null)
            return 0;
        
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        
        // if (left + right + node.val < maxValue ) then the result will not include the
        // parent node which means the maximum path is in the left branch or right branch
        maxValue = Math.max(maxValue, left + right + node.val);
        
        return Math.max(left, right) + node.val;
    }
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
}


