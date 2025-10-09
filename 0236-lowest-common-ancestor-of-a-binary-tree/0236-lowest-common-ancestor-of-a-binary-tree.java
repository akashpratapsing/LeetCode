/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pPath = new ArrayList<>();
        getPaths(root, pPath, p);
        List<TreeNode> qPath = new ArrayList<>();
        getPaths(root, qPath, q);


        int left = 0, right = 0;
        TreeNode ans = null;

        while (left < pPath.size() && right < qPath.size()){

            if (pPath.get(left) == qPath.get(right)){
                ans = pPath.get(left);
            }
            left++;
            right++;
        }

        return ans;

    }

    public boolean getPaths(TreeNode root, List<TreeNode> list, TreeNode target) {

        if (root == null) {
            return false;
        }

        list.add(root);
        if (root == target) {
            return true;
        }

        if (getPaths(root.left, list, target) || getPaths(root.right, list, target)) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }
}