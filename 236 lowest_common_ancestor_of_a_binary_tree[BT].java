/*
236. Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow 
a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of 
nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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
        if (root == null || p == null || q == null) return null;
        
        // found one of the 2 nodes
        if (p == root || q == root) return root;
        
        // try to find the root of either p or q in left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // try to find the root of either p or q in right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // if both p and q have been found, return that root as LCA
        //      this is what will ultimately give us our LCA as we unrecurse
        if (left != null && right != null) return root;
        
        // if p and q are not in same subtree, just return whatever has been found
        if (left != null)
            return left;
        else
            return right;
    }
}

