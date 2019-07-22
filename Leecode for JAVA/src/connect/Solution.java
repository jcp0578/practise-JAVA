package connect;

/*
 * 填充每个节点的下一个右侧节点指针 II
 * 先右后左
 * AC
 * 2ms - 96.25%
 * 
 */
public class Solution {
	public Node connect(Node root) {
		addNext(root);
		return root;
	}

	private void addNext(Node node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			return;
		if (node.left != null && node.right != null) {
			node.left.next = node.right;
		}
		Node next_node, p;
		next_node = null;
		p = node.next;
		while (p != null) {
			if (p.left != null) {
				next_node = p.left;
				break;
			} else if (p.right != null) {
				next_node = p.right;
				break;
			} else
				p = p.next;
			;
		}
		if(next_node!=null)
		{
			if (node.right != null) {
				node.right.next = next_node;
			} else {
				node.left.next = next_node;
			}
		}

		addNext(node.left);
		addNext(node.right);
	}

	public static void main(String[] args) {
		Node node7 = new Node(7, null, null, null);
		Node node5 = new Node(5, null, null, null);
		Node node4 = new Node(4, null, null, null);
		Node node3 = new Node(3, null, node7, null);
		Node node2 = new Node(2, node4, node5, null);
		Node root = new Node(1, node2, node3, null);
		Solution test = new Solution();
		test.connect(root);
		if (root.left.next == root.right)
			System.out.println(true);
		else
			System.out.println(false);

	}

}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};