/*
226. Invert Binary Tree
---
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
public class invertBinaryTree{
    
    // recursive DFS
    public TreeNode invertTreeRecursiveDFS(TreeNode root) {
        if (root == null)
            return null;
     
        TreeNode tempRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tempRight);
     
        return root;
    }
    
    //iterative BFS using Queue
    //queue = FIFO => BFS
    //stack = LIFO => DFS,  change queue to stack and get same solution but with DFS
    public TreeNode invertTreeIterativeBFS(TreeNode root) {
        if (root == null)
            return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            TreeNode tempRight = node.right;
            node.right = node.left;
            node.left = tempRight;
            
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        
        return root;
    }
}

