package postorderTraversal;

/*
 * 二叉树的后序遍历
 * 
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> out = new ArrayList<>();
		if (root == null)
			return out;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode pre = null;
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
		while (!stack.isEmpty()) {
			p = stack.pop();
			if (p.right == null || p.right == pre) {
				out.add(p.val);
				pre = p;
			} else {
				stack.push(p);
				p = p.right;
				while (p != null) {
					stack.push(p);
					p = p.left;
				}
			}
		}
		return out;
	}

	public TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public String treeNodeToString(TreeNode root) {
		if (root == null) {
			return "[]";
		}

		String output = "";
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (node == null) {
				output += "null, ";
				continue;
			}

			output += String.valueOf(node.val) + ", ";
			nodeQueue.add(node.left);
			nodeQueue.add(node.right);
		}
		return "[" + output.substring(0, output.length() - 2) + "]";
	}

	public void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
		if (node == null) {
			System.out.println("Empty tree");
			return;
		}

		if (node.right != null) {
			prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
		}

		System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

		if (node.left != null) {
			prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
		}
	}

	public void prettyPrintTree(TreeNode node) {
		this.prettyPrintTree(node, "", true);
	}

	public static void main(String[] args) {
		String s1 = "[1,2,2,3]";
		Solution test = new Solution();
		TreeNode root = test.stringToTreeNode(s1);
		test.prettyPrintTree(root);
		System.out.println(test.treeNodeToString(root));
		System.out.println(test.postorderTraversal(root));

	}
}
