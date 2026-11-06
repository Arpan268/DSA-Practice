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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        int zigzag = 0;
        if (root == null) {
            return ans;
        }
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int count = q.size();

            while (count > 0) {
                TreeNode current = q.poll();
                currentLevel.add(current.val);

                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
                count--;
            }
            if (zigzag % 2 == 1) {
                Collections.reverse(currentLevel);
            }
            zigzag++;
            ans.add(currentLevel);
        }
        return ans;
    }
}