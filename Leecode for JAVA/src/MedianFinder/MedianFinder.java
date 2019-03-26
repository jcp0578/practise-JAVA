package MedianFinder;

/*
 * 数据流的中位数
 * 二叉搜索树
 * AC but slow
 * 261ms - 51.91%
 */
public class MedianFinder {
	int len;
	TreeNode root;

	public MedianFinder() {
		this.len = 0;
		this.root = null;
	}

	public void addNum(int num) {
		len++;
		if (this.root == null)
			this.root = new TreeNode(num);
		else {
			addNode(num, this.root);
		}
	}

	private void addNode(int num, TreeNode node) {
		if (num == node.val) {
			node.same_nums++;
		} else if (num < node.val) {
			node.small_nums++;
			if (node.left == null) {
				node.left = new TreeNode(num);
			} else {
				addNode(num, node.left);
			}
		} else {
			node.big_nums++;
			if (node.right == null) {
				node.right = new TreeNode(num);
			} else {
				addNode(num, node.right);
			}
		}

	}

	public double findMedian() {
		if ((len & 1) != 0) {
			return (double) findTree((len + 1) / 2, this.root, 0, 0);
		} else {
			return (findTree(len / 2, this.root, 0, 0) + findTree(len / 2 + 1, this.root, 0, 0)) / 2.0;
		}

	}

	private int findTree(int k, TreeNode node, int small_num, int big_num) {
		small_num += node.small_nums;
		big_num += node.big_nums;
		if (k <= small_num)// 查找的数小于当前值
		{
			small_num -= node.small_nums;
			return findTree(k, node.left, small_num, big_num + node.same_nums);
		} else if (k <= small_num + node.same_nums)// 为当前值
		{
			return node.val;
		} else {
			big_num -= node.big_nums;
			return findTree(k, node.right, small_num + node.same_nums, big_num);
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MedianFinder obj = new MedianFinder();
		double param_2;
		obj.addNum(6);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(10);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(2);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(6);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(5);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(0);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(6);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(3);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(1);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(0);
		param_2 = obj.findMedian();
		System.out.println(param_2);
		obj.addNum(0);
		param_2 = obj.findMedian();
		System.out.println(param_2);
	}
}

class TreeNode {
	int val;
	int small_nums;
	int big_nums;
	int same_nums;
	TreeNode left;
	TreeNode right;

	TreeNode(int v) {
		this.val = v;
		this.same_nums = 1;
		this.big_nums = 0;
		this.small_nums = 0;
		this.left = null;
		this.right = null;
	}
}