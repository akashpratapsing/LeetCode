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
        List<Integer> str = new ArrayList<>();
        getPaths(root, ans, str);
        return ans;
    }

    public void getPaths(TreeNode root, List<String> list, List<Integer> str){

        if (root == null){
            return;
        }

        str.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            int n = str.size();
            for (int i = 0; i < n - 1; i++){
                sb.append(str.get(i)).append("->");
            }
            sb.append(str.get(n - 1));
            list.add(sb.toString());
        }else {
            getPaths(root.left, list, str);
            getPaths(root.right, list, str);
        }
        
        str.remove(str.size() - 1);
    }
}