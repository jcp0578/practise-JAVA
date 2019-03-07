package kthSmallest;

/*
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/submissions/
 * 中序遍历后输出
 * AC 1ms
 * https://leetcode-cn.com/submissions/detail/13841206/
 */
import util.TreeNode;

public class Solution {
	int num = 0;
	int num_find = 0;
	int out_t = 0;

	public int kthSmallest(TreeNode root, int k) {

		num = 0;
		num_find = k;
		mid_order_K(root);
		return out_t;

	}

	private void mid_order_K(TreeNode root) {
		if (num < num_find && root != null) {
			mid_order_K(root.left);
			if (++num == num_find)
				out_t = root.val;
			mid_order_K(root.right);
		}
	}
}
