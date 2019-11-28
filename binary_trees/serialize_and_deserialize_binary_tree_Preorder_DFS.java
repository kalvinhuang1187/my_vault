/*
297. Serialize and Deserialize Binary Tree
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

    // DFS- preorder: [1,2,null,null,3,4,null,null,5,null,null]
    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
    
    //--------------
    
    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> l = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(l);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));