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
    private HashMap<Integer ,Integer> inorderMap =new HashMap<>();
    private int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preoder,int start, int end){
        if(start>end){
            return null;
        }
        int rootval=preoder[preindex++];
        TreeNode root=new TreeNode(rootval);
        int inorderindex=inorderMap.get(rootval);
        root.left=build(preoder,start,inorderindex-1);
        root.right=build(preoder,inorderindex+1,end);
        return root;
    }
}