package maxPathSum;

/*
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 
 * AC 3ms
 * https://leetcode-cn.com/submissions/detail/13815220/
 * 
 * Solution_fast 更佳
 */
import util.TreeNode;

public class Solution {
	int out_t;

	public int maxPathSum(TreeNode root) {
		out_t = root.val;
		maxSum(root);
		return out_t;
	}

	private int maxSum(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		int l_max, r_max;
		l_max = maxSum(root.left);
		r_max = maxSum(root.right);

		int out_max;
		out_max=root.val;
		if(l_max > 0)
			out_max = Math.max(root.val + l_max, out_max);
		if(r_max > 0)
			out_max = Math.max(root.val + r_max, out_max);

		int max_t = Math.max(l_max, r_max);
		max_t = Math.max(max_t, out_max);
		if(l_max > 0 && r_max > 0)
		{
			max_t = Math.max(root.val + l_max+ r_max, max_t);
		}

		out_t = Math.max(max_t, out_t);

		return out_max;
	}

}
