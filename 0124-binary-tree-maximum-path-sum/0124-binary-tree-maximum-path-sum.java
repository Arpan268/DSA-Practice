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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getSum(root);

        return max;
    }

    private int getSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getSum(root.left);
        int right = getSum(root.right);

        if(left < 0 && right >= 0) {
            max = Math.max(max, root.val + right);
            return root.val + right;
        }
        else if(left >= 0 && right < 0) {
            max = Math.max(max, root.val + left);
            return root.val + left;
        }
        else if(left < 0 && right < 0) {
            max = Math.max(max, root.val);
            return root.val;
        }
        else {
            max = Math.max(max, root.val + left + right);
            return root.val + Math.max(left, right);
        }
    }
}