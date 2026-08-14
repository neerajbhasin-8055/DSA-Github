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
        TreeNode node;
        int idx ;
        NodeInfo(TreeNode node , int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0 ;
        if(root == null){
            return maxWidth;
        }
        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root,1));
        while(!q.isEmpty()){
            int size = q.size();
            int minIndexVal = q.peek().idx;
            int first = 0 ; 
            int last = 0; 
            for(int i = 0 ; i <size ; i++){
                NodeInfo nod = q.poll();
                TreeNode node = nod.node;
                int index = nod.idx - minIndexVal;
                if(i == 0 ) first = index;
                if( i == size - 1 ) last  = index ;
                if(node.left != null){
                    q.offer(new NodeInfo(node.left, 2*index));
                }
                if(node.right !=null){
                    q.offer(new NodeInfo(node.right, 2*index+1));
                }
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
} 