/*
102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
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
public class Solution {

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        
        //each sublist corresponds to height level in tree
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }

        //get level and add the value to arraylist
        res.get(height).add(root.val);

        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    } 

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelHelper(result, root, 0);
        return result;
    }
}

