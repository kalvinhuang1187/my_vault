/*
105. Construct Binary Tree from Preorder and Inorder Traversal
---
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
public class Solution {
    /*
    Say we have 2 arrays, PRE and IN.
    Preorder traversing implies that PRE[0] is the root node.
    Then we can find this PRE[0] in IN, say it's IN[5].
    Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
    Recursively doing this on subarrays, we can build a tree out of it
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length)
            return null;
            
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {
        if (preLow > preHigh || inLow > inHigh)
            return null;
            
        TreeNode root = new TreeNode(preorder[preLow]);
        
        int inorderRootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                inorderRootIndex = i;
                break;
            }
        }
        
        int leftTreeLength = inorderRootIndex - inLow;
        root.left = buildTreeHelper(preorder, preLow + 1, preLow + leftTreeLength, inorder, inLow, inorderRootIndex + 1);
        root.right = buildTreeHelper(preorder, preLow + leftTreeLength + 1, preHigh, inorder, inorderRootIndex + 1, inHigh);
        
        return root;
    }
}

