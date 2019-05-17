package isSymmetric;

import java.util.ArrayList;

import util.TreeNode;
import util.Wrapper;

/*
 * 对称二叉树
 * error
 */
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		ArrayList<Integer> pre = new ArrayList<>();
		preorder(root, pre);
		int len = pre.size();
		for (int i = 0; i < len / 2; i++) {
			if (pre.get(i) == pre.get(len - i - 1))
				continue;
			else
				return false;
		}
		return true;

	}

	private void preorder(TreeNode node, ArrayList<Integer> pre) {
		if (node == null)
			return;
		preorder(node.left, pre);
		pre.add(node.val);
		preorder(node.right, pre);
		return;
	}

	public static void main(String[] args) {
		String test_in_str = "[1,2,2,2,null,2]";
		TreeNode test_in = Wrapper.stringToTreeNode(test_in_str);
		Solution test = new Solution();
		System.out.println(test.isSymmetric(test_in));

	}

}
