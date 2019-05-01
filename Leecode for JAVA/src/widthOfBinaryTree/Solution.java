package widthOfBinaryTree;

import java.util.HashMap;

import util.TreeNode;

/*
 * 二叉树最大宽度
 * AC
 * 7ms - 88.83%
 * 前序遍历，利用HashMap记录每个层次的最左值和最右值
 * 
 */
public class Solution {
	int _max = 0;
	HashMap<Integer, Integer> _left;
	HashMap<Integer, Integer> _right;

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		this._max = 0;
		this._left = new HashMap<>();
		this._right = new HashMap<>();
		this.find(root, 1, 1);
		
		int k=1;
		while(true)
		{
			if(this._left.containsKey(k))
			{
				int diff_t = this._right.get(k) - this._left.get(k) + 1;
				if (diff_t > this._max)
					this._max = diff_t;					
			}
			else
				break;
			k++;
		}

		return this._max;
	}

	private void find(TreeNode node, int k, int i) {
		if (this._left.containsKey(k)) {
			if (i < this._left.get(k))
				this._left.put(k, i);
			if (i > this._right.get(k))
				this._right.put(k, i);
		} else {
			this._left.put(k, i);
			this._right.put(k, i);
		}

		if (node.left != null)
			this.find(node.left, k + 1, 2 * i - 1);
		if (node.right != null)
			this.find(node.right, k + 1, 2 * i);
	}
}
