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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }

    public void helper(TreeNode root){

        if (root == null) return;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        max = Math.max(left + right, max);

        helper(root.left);
        helper(root.right);
    }

    public int getHeight(TreeNode root){

        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }




}