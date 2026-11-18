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
    int preStart = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(0, inorder.length - 1, preorder, map);
    }

    private TreeNode build(int inStart, int inEnd, int[] preorder, Map<Integer, Integer> map) {
        if(inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart++];
        TreeNode root = new TreeNode(rootVal);
        int i = map.get(rootVal);

        root.left = build(inStart, i - 1, preorder, map);
        root.right = build(i + 1, inEnd, preorder, map);

        return root;
    }
}