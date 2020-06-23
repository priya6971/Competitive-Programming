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
class Solution {
    public int countNodes(TreeNode root) {
   
        if(root == null){
            return 0;
        }
        
        // Here we calculate the tree left height and right height
        int left  = calculateLeftHeight(root) +1;
        int right = calculateRightHeight(root)+1;
        
        // if left height and right height are equal then the number of nodes should be 2^h-1
        if(left==right) {
            return (int)Math.pow(2,left) -1;
        } else {
           return 1+countNodes(root.left) + countNodes(root.right);
        }
    }
    
    
    private int calculateLeftHeight(TreeNode root){
        int height = 0;
        if(root == null){
            return 0;
        }
        
        while(root.left!=null){
            height++;
            root = root.left;
        }
        
        return height;
    }
    
    private int calculateRightHeight(TreeNode root){
        int height = 0;
        if(root == null){
            return 0;
        }
        
        while(root.right!=null){
            height++;
            root = root.right;
        }
        
        return height;
    }
    
    
    
}