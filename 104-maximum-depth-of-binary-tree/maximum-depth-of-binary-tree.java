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
    public int ans=0;
    public int maxDepth(TreeNode root) {
        int max=1;
        solution(root,max);
        return ans;
    }
    public void solution(TreeNode root,int max){
        if(root==null){
            return;
        }
        ans=Math.max(ans,max);
        solution(root.left,max+1);
        solution(root.right,max+1);



    }
}