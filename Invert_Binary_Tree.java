/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


/* 
Approach Used - Recursive Approach
Time Complexity - O(n) 

Each node is traversed one time and there are n nodes so overall time complexity is O(n)
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        
        else{
        
        invertTree(root.left);
        invertTree(root.right);
        
        TreeNode temp;
        
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        }
        return root;
    }
}