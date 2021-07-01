package Leetcode.Lowest_Common_Ancestor_of_a_Binary_Tree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q); // 5
		TreeNode right = lowestCommonAncestor(root.right, p, q); //

		if (left != null && right != null)
			return root;
		else if (left == null && right != null)
			return right;
		else if (right == null && left != null)
			return left;
		else
			return null;

	}
}