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
    private class NodeInfo {
        TreeNode root;
        int idx;
       

        NodeInfo(TreeNode root, int idx) {
            this.root = root;
            this.idx = idx;
            
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        
        int maxWidth = 0;
        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root,0));
        
        while(!q.isEmpty()){
            int size = q.size();
            int minIndexAtLevel = q.peek().idx;
            int first = 0 , last = 0 ;
            
            
            for(int i = 0 ; i < size ; i++){
                NodeInfo nod = q.poll();
                TreeNode node = nod.root;

                int index = nod.idx - minIndexAtLevel;

                if( i == 0) first = index;
                if( i == size - 1) last = index;
                if(node.left != null){
                    q.offer(new NodeInfo(node.left, 2*index+1));
                 
                }
                if(node.right != null){
                    q.offer(new NodeInfo(node.right, 2*index+2 ));
                }
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
}