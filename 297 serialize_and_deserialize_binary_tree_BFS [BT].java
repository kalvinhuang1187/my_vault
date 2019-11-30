/*
297. Serialize and Deserialize Binary Tree [BFS]
---
Serialization is the process of converting a data structure or object into a sequence of bits
so that it can be stored in a file or memory buffer, or transmitted across a network connection
link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not
necessarily need to follow this format, so please be creative and come up with different
approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and
deserialize algorithms should be stateless.
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
public class Codec {

    // Encodes a tree to a single string.
    // code very similar to level order traversal of BT
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            
            if(curr == null) {
                sb.append("n,");
            
            }
            else {
                sb.append(curr.val).append(",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        boolean left = true;
        
        if(nodes.length == 0 || nodes[0].equals("n"))
            return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        TreeNode curr = root;
        
        //used to keep track of current level and which node to attach children to
        Queue<TreeNode> q = new LinkedList<>();
        
        for (int i = 1; i < nodes.length; i++) {
            if(!nodes[i].equals("n")){
                TreeNode node = new TreeNode(Integer.valueOf(nodes[i]));
                
                if (left) 
                    curr.left = node;
                else
                    curr.right = node;
                    
                q.add(node);
            }
            
            left = !left;
            
            // left && q !empty means children will be attached to left node,
            // so make left node the curr node (i think???)
            if (left && !q.isEmpty())
                curr = q.poll();
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

