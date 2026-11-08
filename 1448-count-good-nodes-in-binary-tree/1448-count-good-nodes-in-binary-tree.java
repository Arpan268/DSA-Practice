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
    public int goodNodes(TreeNode root) {
        return compute(root, root.val);
    }

    private int compute(TreeNode root, int max) {
        if(root == null) {
            return 0;
        }
        if(root.val >= max) {
            max = root.val;
            return 1 + compute(root.left, max) + compute(root.right, max);
        }
        return compute(root.left, max) + compute(root.right, max);
    }
}