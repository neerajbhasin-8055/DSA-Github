/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /* 

 Here we are given with a complete binary tree tha and its property is 
 Total nodes = 2^h-1 (h = height of the binary tree)
 and if we are standing at some particular node from where the left and right height is equal that means the tree is completely filled so we can simply use the formula and calculate the number of nodes for that level "( 2 << leftHeight/rightHeight) - 1"
 and if the height is not equal we recursively visit each node and apply the above formula.
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = getLeftHeight(root); // calculating left height
        int rh = getRightHeight(root); // calculating right height

        if(lh == rh){
            return (2 << lh) -1 ; // if equal apply formula
        }
        return 1 + countNodes(root.left) + countNodes(root.right); // recursive calls
    }
    public int getLeftHeight(TreeNode root){
        int cnt = 0 ;
        while(root.left != null){
            cnt++;
            root = root.left;
        }
        return cnt;
    }
    public int getRightHeight(TreeNode root){
        int cnt = 0 ; 
        while(root.right != null){
            cnt++;
            root = root.right;
        }
        return cnt;
    }
}