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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> value=new ArrayList<>();
        solution(root,k,value);
        return value.get(k-1);
    }
    public void solution(TreeNode root, int k,List<Integer> value){
        if(root==null){
            return;
        }
        solution(root.left,k,value);
        value.add(root.val);
        solution(root.right,k,value);


    }
}