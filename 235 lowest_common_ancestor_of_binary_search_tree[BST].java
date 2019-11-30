/*
235. Lowest Common Ancestor of a Binary Search Tree
---
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two 
nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to
be a descendant of itself).”
        _______10______
       /              \
    ___6__          ___18__
   /      \        /      \
  4        8      15       21
    \
     5 

For example, the lowest common ancestor (LCA) of nodes 4 and 18 is 10.
Another example is LCA of nodes 5 and 6 is 6, since a node can be a descendant of itself
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}

