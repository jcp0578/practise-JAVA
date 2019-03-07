package lowestCommonAncestor;

import util.TreeNode;

/*
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * AC 15ms
 * https://leetcode-cn.com/submissions/detail/13802874/
 * 
 */
public class Solution {
	public TreeNode find_p, find_q, out;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		find_p = p;
		find_q = q;
		int find_status = 0;
		find(root, find_status);
		return out;
	}

	private int find(TreeNode root, int find_status) {
		// TODO 自动生成的方法存根
		if (root == null) {
			return find_status;
		}
		if (find_status == 9) {
			return 9;
		}
		int status_l, status_r;
		status_l = find(root.left, find_status);
		status_r = find(root.right, find_status);

		int status_t = status_l + status_r;

		if (status_t == 0) {
			if (root.val == find_p.val)
				status_t=1;
			if (root.val == find_q.val)
				status_t=2;
		} else if (status_t == 1) {
			if (root.val == find_q.val) {
				out = root;
				status_t = 9;
			}
		} else if (status_t == 2) {
			if (root.val == find_p.val) {
				out = root;
				status_t = 9;
			}
		} else if (status_t == 3) {
			out = root;
			status_t=9;
		} else {
			status_t = 9;
		}
		return status_t;
	}
}
