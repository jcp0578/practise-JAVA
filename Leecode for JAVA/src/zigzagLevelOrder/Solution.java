package zigzagLevelOrder;

/*
 * 二叉树的锯齿形层次遍历
 * 中序遍历，按层次保存数据
 * 将偶数层反转
 * AC
 * 2ms - 83.52%
 */
import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Order(res, root, 0);
		return res;
	}

	private void Order(List<List<Integer>> res, TreeNode node, int k) {
		if (node == null)
			return;
		if (k >= res.size())
			res.add(new ArrayList<Integer>());
		if (k % 2 == 0)
			res.get(k).add(node.val);
		else
			res.get(k).add(0, node.val);

		Order(res, node.left, k + 1);
		Order(res, node.right, k + 1);
	}
}
