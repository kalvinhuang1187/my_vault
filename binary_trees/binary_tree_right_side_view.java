/*
199. Binary Tree Right Side View
---
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode node, List<Integer> result, int level) {
        if (node == null)
            return;
        
        // only add 1 value from each level to result    
        //   if right-most node has been found, the bucket for this level will be filled and level != result.size()
        if (level == result.size())
            result.add(node.val);
        
        // start from the most right branch and work your way back to left side of tree 
        rightView(node.right, result, level+1);
        rightView(node.left, result, level+1);
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);

        List<Integer> output = rightSideView(tree.root);
        System.out.println(output);   // prints [1, 3, 4]
    }
}

