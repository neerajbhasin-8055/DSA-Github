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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> ls = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode rt = q.remove();
                ls.add(rt.val);
                if (rt.left != null) {
                    q.add(rt.left);
                }
                 if (rt.right != null) {
                    q.add(rt.right);
                }
            }
            result.add(ls);
        }
        return result;
    }
}