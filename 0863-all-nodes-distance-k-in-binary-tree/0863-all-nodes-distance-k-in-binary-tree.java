/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /* 
 In this problem the main problem is we could have the nodes at the k distance in the upward direction of the target node
 but in binary trees we can only explore in the one direction - so to solve that problem we will map every node to its parent.

 1 - use hashmap to map node with its parent - (BFS approach)
 2 - traverse from the target node, radially (upward, left and right) ;
 3 - calculate the distance at each and everypoint, once the distance == k the values that are there in the queue
 will be the values we require as our result 
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Map<TreeNode,TreeNode> parentMap = parentMapping(root, new HashMap<>());
        Map<TreeNode,Boolean> visited= new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int distance = 0 ;
        while(!q.isEmpty()){
            int size = q.size();
            if(distance == k){
                break;
            }
            distance++;
            for(int i = 0 ; i < size ; i++){
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left) == null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parentMap.get(current) != null && visited.get(parentMap.get(current))== null ){
                    q.offer(parentMap.get(current));
                    visited.put(parentMap.get(current),true);
                }
            }
        }
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            result.add(node.val);
        }
        return result;
    }
    public Map<TreeNode,TreeNode> parentMapping(TreeNode node, HashMap<TreeNode,TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left != null){
                map.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right !=null){
                map.put(current.right,current);
                q.offer(current.right);
            }
        }
        return map;
    }
    
}