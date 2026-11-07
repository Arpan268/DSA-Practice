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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        q.add(root);

        while(!q.isEmpty()) {
            int count = q.size();

            while(count > 0) {
                TreeNode current = q.poll();
                if(count == 1) {
                    ans.add(current.val);
                }

                if(current.left != null) {
                    q.add(current.left);
                }
                if(current.right != null) {
                    q.add(current.right);
                }
                count--;
            }
        }

        return ans;
    }
}