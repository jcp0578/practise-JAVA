package countSmaller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
   *   计算右侧小于当前元素的个数
   *   二叉搜索树
   *   好题
 * AC 
 * 12ms-87.63%
 * 
 */
public class Solution {
	public List<Integer> countSmaller(int[] nums) {
		ArrayList<Integer> ret = new ArrayList<>();
		int len = nums.length;
		if (len == 0)
			return ret;
		ret.add(0);
		TreeNode root = new TreeNode(nums[len - 1]);
		for (int i = len - 2; i >= 0; i--) {
			ret.add(add_node(nums[i], root, 0));
		}
		Collections.reverse(ret);
		return ret;
	}

	int add_node(int val, TreeNode node, int count_t) {
		if (val <= node.val) {
			node.count++;// 小于等于val的数量
			if (node.left == null) {
				node.left = new TreeNode(val);
				return count_t;
			} else {
				return add_node(val, node.left, count_t);
			}
		} else {
			count_t += node.count;// 加上大于父节点小余等于node.val的个数
			if (node.right == null) {
				node.right = new TreeNode(val);
				return count_t;
			} else {
				return add_node(val, node.right, count_t);
			}
		}
	}

	public static void main(String[] args) {
		int[] test_in = { 6, 7, 6, 5, 2, 6, 5, 5 };
		Solution test = new Solution();
		System.out.println(test.countSmaller(test_in));
	}

}

class TreeNode {
	int val;
	int count;// 表示左子数节点数量，即已遍历部分大于父节点小余等于node.val的个数
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.count = 1;
	}

}