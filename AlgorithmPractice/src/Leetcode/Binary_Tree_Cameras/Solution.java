package Leetcode.Binary_Tree_Cameras;
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
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
}
public class Solution {
    private static final int NULL = 0;
    private static final int COVER = 1;
    private static final int CAMERA = 2;
    private int res;
    public int minCameraCover(TreeNode root){
        if(dfs(root)==NULL) res++;
        return res;
    }
    
    public int dfs(TreeNode node){
        if(node==null)
            return COVER;
        
        int left=dfs(node.left);
        int right=dfs(node.right);
        if(left == NULL || right ==NULL)
        {
            res++;
            return CAMERA;
        }
        if(left==CAMERA || right==CAMERA) return COVER;
        return NULL;
    }
}
