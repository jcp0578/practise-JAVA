package codec;


/*
 * 二叉树的序列化与反序列化
 * AC but slow
 * 37ms - 30.07%
 * 
 */
import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuffer out = new StringBuffer();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			if (p == null) {
				out.append("null,");
			} else {
				out.append(String.valueOf(p.val));
				out.append(',');
				queue.offer(p.left);
				queue.offer(p.right);
			}
		}
		out.deleteCharAt(out.length() - 1);
		return out.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] save = data.split(",");
		if (save.length <= 1) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(save[0]));
		queue.offer(root);
		int i = 1;
		while (i < save.length) {
			try {
				TreeNode p = queue.poll();
				if (save[i].equals("null")) {
					p.left = null;
				} else {
					TreeNode left = new TreeNode(Integer.parseInt(save[i]));
					p.left = left;
					queue.offer(left);
				}
				if (save[i + 1].equals("null")) {
					p.right = null;
				} else {
					TreeNode right = new TreeNode(Integer.parseInt(save[i + 1]));
					p.right = right;
					queue.offer(right);
				}

			} catch (Exception e) {
				//e.printStackTrace(System.out);
			} finally {
				i += 2;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		String test_in = "1,null,2";
		System.out.println(codec.serialize(codec.deserialize(test_in)));

	}

}
