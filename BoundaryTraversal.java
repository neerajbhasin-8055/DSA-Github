/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(!leaf(root)){
            result.add(root.data);
        }
        
        addLeft(root.left,result);
        addLeaves(root,result);
        addRight(root.right,result);
        return result;
    }
    public boolean leaf(Node root){
        return root.left == null && root.right == null;
    }
    public void addLeft(Node root, ArrayList<Integer> result){
        Node curr = root;
        while(curr!=null){
            if(!leaf(curr)){
            result.add(curr.data);
        }
        if(curr.left != null){
            curr = curr.left;
        }else{
            curr = curr.right;
            
        }
        }
        
    }
    public void addLeaves(Node root, ArrayList<Integer> result){
        if(root == null) return ;
        if(leaf(root)){
            result.add(root.data);
            return;
        }
        addLeaves(root.left,result);
        addLeaves(root.right,result);
    }
    public void addRight(Node root, ArrayList<Integer> result){
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = root ;
        while(curr!=null){
            if(!leaf(curr)){
            temp.add(curr.data);
        }
        if(curr.right != null){
            curr = curr.right;
        }else{
            curr = curr.left;
        }
        }
        
        for(int i = temp.size()-1; i >= 0; i--){
            result.add(temp.get(i));
        }
    }
}