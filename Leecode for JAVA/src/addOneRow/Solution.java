package addOneRow;

import util.TreeNode;
import util.Wrapper;

/*
 * tital:在二叉树中增加一行
 * url:https://leetcode-cn.com/submissions/detail/29749540/
 * time:1ms - 100%
 * memory:38.9MB - 84.13%
 * AC
 * 
 */
public class Solution {

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode temp = new TreeNode(v);
			temp.left = root;
			return temp;
		}
		findAndAdd(root, v, d, 1);
		return root;
	}

	private void findAndAdd(TreeNode node, int v, int d, int k) {
		if (k == d - 1) {
			TreeNode leftTemp = new TreeNode(v);
			TreeNode rightTemp = new TreeNode(v);
			leftTemp.left = node.left;
			rightTemp.right = node.right;
			node.left = leftTemp;
			node.right = rightTemp;
			return;
		}
		if (node.left != null)
			findAndAdd(node.left, v, d, k + 1);
		if (node.right != null)
			findAndAdd(node.right, v, d, k + 1);
		return;
	}

	public static void main(String[] args) {
		String test_in_str = "[1,2,2,2,null,2]";
		TreeNode test_in = Wrapper.stringToTreeNode(test_in_str);
		Wrapper.prettyPrintTree(test_in);
		Solution test = new Solution();
		TreeNode test_out = test.addOneRow(test_in, 10, 2);
		Wrapper.prettyPrintTree(test_out);
		System.out.println(Wrapper.treeNodeToString(test_out));

	}

}
