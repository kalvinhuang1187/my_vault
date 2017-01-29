/*
103. Binary Tree Zigzag Level Order Traversal aka Traverse the tree in spiral form
---
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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

public class BinaryTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //BFS
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            
            // get a count of all nodes on this level before we add in more children
            int count = queue.size();
            
            for (int i = 0; i < count; i++) {
                TreeNode n = queue.remove();
                
                // check to see if we insert nodes from head or tail depending on level
                if (result.size() % 2 == 0) {
                    level.add(n.val);   // add from tail
                }
                else {
                    level.add(0, n.val);    // add from head
                }

                // add node's children to the queue
                if(n.left != null)
                    queue.add(n.left);
                if(n.right != null)
                    queue.add(n.right);
            }
            result.add(level);
        }
        return result;
    }
}

