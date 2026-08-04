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
    private class NodeInfo{
        TreeNode n;
        int level ;
        NodeInfo(TreeNode n, int level){
            this.n = n;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>  result = new ArrayList<>();
        if(root == null) return result;;
        Set<Integer> set = new HashSet<>();
        Queue<NodeInfo> q  = new LinkedList<>(); 
        q.offer(new NodeInfo(root,0));
        while(!q.isEmpty()){
            NodeInfo nod = q.poll();
            TreeNode node = nod.n ;
            int level = nod.level;
            if(!set.contains(level)){
                set.add(level);
                result.add(node.val);
            }
            if(node.right != null){
                q.offer(new NodeInfo(node.right, level+1));
            }
            if(node.left != null){
                q.offer(new NodeInfo(node.left,level+1));
            }
        }
        return result;
    }
}