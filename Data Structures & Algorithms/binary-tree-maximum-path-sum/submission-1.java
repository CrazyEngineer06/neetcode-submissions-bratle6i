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
    /*
        So here i want to tell the maximum path between any nodes.
        in the array res i will store the maximum path's root
        then i traverse the left and right subtree and determine the max path of left 
        and right and if negative then return 0 to the parent node
    */
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{root.val}; // declare an array so size 1 with value root.val
        dfs(root,res);
        return res[0];
    }
    public int dfs(TreeNode root,int[] res){
        if(root == null) return 0;

        int leftMax  = Math.max(dfs(root.left,res),0);
        int rightMax = Math.max(dfs(root.right,res),0);

        res[0] = Math.max(res[0],root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax,rightMax);
    }
}
