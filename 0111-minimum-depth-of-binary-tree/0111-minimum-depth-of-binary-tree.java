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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return minDepth1(root);
    }
    public int minDepth1(TreeNode root) {
        if(root == null)
            return (int)Math.pow(10, 9);
        if(root.left == null && root.right == null)
            return 1;
        return Math.min(minDepth1(root.left) + 1, minDepth1(root.right)+1);
    }
}