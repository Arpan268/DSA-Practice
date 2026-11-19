/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "null";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            if(current != null) {
                q.add(current.left);
                q.add(current.right);
            }
            if(current == null) {
                sb.append("null,");
            }
            else {
                sb.append(current.val).append(",");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String nodes[] = data.split(",");
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);

        while(i < nodes.length - 1) {
            TreeNode current = q.poll();
            if(!nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(current.left);
            }
            if(!nodes[i + 1].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                q.add(current.right);
            }
            i += 2;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));