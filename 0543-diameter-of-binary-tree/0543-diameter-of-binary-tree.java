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
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }

    public void helper(TreeNode root, int[] max){

        if (root == null) return;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        max[0] = Math.max(left + right, max[0]);

        helper(root.left, max);
        helper(root.right, max);

    }

    public int getHeight(TreeNode root){

        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }




}