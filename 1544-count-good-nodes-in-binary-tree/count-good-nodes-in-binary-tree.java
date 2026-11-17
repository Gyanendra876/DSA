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
    public int count=0;
    public int goodNodes(TreeNode root) {
        int max=root.val;
        solution(root,max);
        return count;
    }
    public void solution(TreeNode root,int max){
        if(root==null)return ;
        if(max<=root.val){
            count++;
        }
        max=Math.max(max,root.val);
        solution(root.left,max);
        solution(root.right,max);

    }
}