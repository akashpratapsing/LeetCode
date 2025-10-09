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
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        getPaths(root, ans, new StringBuilder());
        return ans;
    }

    public void getPaths(TreeNode root, List<String> list, StringBuilder str){

        if (root == null){
            return;
        }
        int len = str.length();
        str.append(root.val);
        if(root.left == null && root.right == null){
            list.add(str.toString());
        }else {
            str.append("->");
            getPaths(root.left, list, str);
            getPaths(root.right, list, str);
        }     
        str.setLength(len);
    }
}