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
        int col;
        int row;
        int val;

        NodeInfo(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root,0,0,nodes);

        Collections.sort(nodes,(a,b)->{
            if(a.col!=b.col){
                return Integer.compare(a.col,b.col);
            }
            if(a.row!=b.row){
                return Integer.compare(a.row,b.row);
            }
            return Integer.compare(a.val,b.val);
        });

        List<List<Integer>> result = new ArrayList<>();
        if(nodes.isEmpty()) return result;

        int prevCol = nodes.get(0).col;
        List<Integer> currCol = new ArrayList<>();
        for(NodeInfo node : nodes){
            if(node.col!=prevCol){
                result.add(currCol);
                currCol = new ArrayList<>();
                prevCol = node.col;
            }
            currCol.add(node.val);
        }
        result.add(currCol);

        return result;
    }
    public void dfs(TreeNode root, int row, int col, List<NodeInfo> nodes){
        if(root == null) return;
        nodes.add(new NodeInfo(col,row,root.val));
        dfs(root.left, row+1,col-1,nodes);
        dfs(root.right,row+1,col+1,nodes);
    }
}