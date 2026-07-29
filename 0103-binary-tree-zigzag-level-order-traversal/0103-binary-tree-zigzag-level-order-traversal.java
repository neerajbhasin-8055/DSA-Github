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
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ls = new ArrayList<>();
            for(int i = 0; i < size ; i++){
                TreeNode node = q.poll();
                ls.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(level%2 !=0){
                Collections.reverse(ls);
            }
            result.add(ls);
           level++;
        }
        return result;
     }
}