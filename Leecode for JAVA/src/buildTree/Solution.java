package buildTree;

import util.TreeNode;
import util.Wrapper;;

/*
 * 从前序与中序遍历序列构造二叉树
 * AC
 * 32ms - 50.92%
 * 
 */
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null)
			return null;
		int len = preorder.length;
		return buildTree(preorder, 0, len - 1, inorder, 0, len - 1);
	}

	private TreeNode buildTree(int[] preorder, int pre_s, int pre_e, int[] inorder, int in_s, int in_e) {
		if (pre_s > pre_e || in_s > in_e)
			return null;

		TreeNode res = new TreeNode(preorder[pre_s]);
		int in_index = in_s;
		for (; in_index <= in_e; in_index++) {
			if (inorder[in_index] == preorder[pre_s])
				break;
		}
		res.left = buildTree(preorder, pre_s + 1, pre_s + (in_index - in_s), inorder, in_s, in_index - 1);
		res.right = buildTree(preorder, pre_s + (in_index - in_s) + 1, pre_e, inorder, in_index + 1, in_e);
		return res;
	}

	public static void main(String[] args) {
		int[] test_in1 = { 3, 9, 20, 15, 7 };
		int[] test_in2 = { 9, 3, 15, 20, 7 };
		Solution test = new Solution();
		TreeNode root=test.buildTree(test_in1, test_in2);
		System.out.println(Wrapper.treeNodeToString(root));

	}

}
