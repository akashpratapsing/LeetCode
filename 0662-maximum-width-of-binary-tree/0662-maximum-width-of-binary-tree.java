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

 class Pair {

    int data;
    TreeNode node;
    
    Pair(TreeNode node, int data){
        this.node = node;
        this.data = data;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans = 0;

        while (!q.isEmpty()){
            int size = q.size();
            int min = q.peek().data;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++){
                Pair pair = q.poll();
                TreeNode currNode = pair.node;
                int currIdx = pair.data - min;
                if (i == 0) first = currIdx;
                if (i == size - 1) last = currIdx;
                if (currNode.left != null) q.offer(new Pair(currNode.left, currIdx * 2 + 1));
                if (currNode.right != null) q.offer(new Pair(currNode.right, currIdx * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;        
    }
}