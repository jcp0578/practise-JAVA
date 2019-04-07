package sumRootToLeaf;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class Solution {
	int _sum;

	public int sumRootToLeaf(TreeNode root) {
		if (root == null)
			return 0;
		int last = 0;
		_sum = 0;
		Deal(root, last);
		return this._sum;
	}

	private void Deal(TreeNode root, int last) {
		int temp=(last << 1) + root.val;
		if (temp > 1000000007)
			temp %= 1000000007;
		if (root.left == null && root.right == null) {
			this._sum += temp;
			if (this._sum > 1000000007)
				this._sum %= 1000000007;
		} else if (root.left == null) {
			Deal(root.right, temp);
		} else if (root.right == null) {
			Deal(root.left, temp);
		} else {
			Deal(root.left, temp);
			Deal(root.right, temp);
		}
	}
    public static TreeNode stringToTreeNode(String input) {
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
        while(!nodeQueue.isEmpty()) {
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
	public static void main(String[] args) {
		
		String test_in="1,1,1,0,null,1,null,1,null,0,null,1,null,0,null,0,null,0,null,1,null,0,null,0,null,1,null,0,null,0,null,1,null,0,1,0,null,1,null,1,null,0,null,0,null,1,null,1,null,0,null,0,1,0,null,1,null,0,null,1,1,1,0,0,null,0,null,1,1,0,null,1,0,1,null,1,null,1,null,0,null,1,null,0,null,0,null,0,null,1,null,0,null,1,0,0,null,0,1,1,1,0,null,1,null,0,null,0,null,0,1,0,null,0,null,1,null,1,null,0,null,0,null,0,null,0,null,0,null,0,0,1,null,1,null,1,null,0,null,0,0,1,null,0,1,1,null,1,null,1,null,0,1,0,null,0,null,0,1,1,1,0,1,1,null,1,null,0,1,1,0,1,null,0,null,1,1,1,null,0,null,1,null,0,null,0,null,1,null,1,null,0,null,1,null,1,1,1,null,1,null,1,0,1,1,1,null,1,0,0,null,0,1,0,null,1,null,0,null,1,null,1,null,null,1,1,null,0,null,1,1,0,null,1,0,1,null,0,null,0,null,1,null,1,0,1,0,1,null,0,null,1,1,0,0,0,null,1,null,1,null,1,null,1,null,1,null,0,null,0,null,1,null,0,null,1,null,null,1,0,null,1,null,0,null,0,null,0,null,1,1,1,null,1,null,1,null,1,null,1,null,1,null,0,null,1,null,1,null,1,null,1,0,0,null,0,0,1,1,1,0,0,null,null,0,null,null,1,null,0,null,0,null,1,null,1,0,1,null,1,null,1,null,null,null,null,0,1,1,0,0,1,1,1,null,null,1,1,0,0,null,0,null,0,null,1,null,0,0,0,null,0,0,0,null,1,null,0,1,1,1,0,1,1,null,0,null,1,null,1,null,1,0,1,null,0,1,0,null,0,null,0,1,1,null,0,0,0,null,0,null,0,null,0,null,0,null,0,1,0,null,0,null,null,0,1,null,0,0,0,null,null,null,null,0,0,null,0,null,null,null,null,null,0,1,0,0,null,null,0,1,1,null,0,0,1,null,0,null,1,0,1,null,1,null,0,1,0,null,1,null,0,null,0,1,0,null,0,null,0,null,null,null,null,0,1,0,1,0,0,0,0,null,1,null,1,0,null,null,0,1,null,null,1,null,0,null,1,null,0,null,1,0,1,null,1,null,1,null,0,null,null,null,null,null,null,null,null,null,null,1,0,null,null,null,null,null,null,null,0,null,0,null,0,null,null,null,0,1,0,null,1,1,0,null,1,null,1,1,0,null,0,1,0,1,1,null,null,null,1,null,1,null,1,0,0,1,0,null,0,0,1,1,0,null,null,null,0,null,1,null,1,0,1,null,1,0,1,null,null,null,0,null,null,null,0,null,null,null,0,0,1,0,1,null,1,null,1,null,0,null,1,null,1,1,0,null,0,null,0,null,1,null,1,null,0,null,null,null,null,null,0,null,0,null,1,null,1,null,0,null,1,null,1,null,null,null,0,null,1,null,0,null,0,null,1,null,0,null,0,null,0,null,0,1,1,1,1,null,1,null,1,0,0,1,1,null,0,0,1,null,1,0,1,null,0,null,1,null,0,null,1,null,1,null,1,null,1,null,null,null,0,null,1,null,null,1,0,null,1,1,null,null,null,null,null,null,0,null,1,null,null,null,0,null,1,null,1,null,0,null,1,null,0,null,0,0,0,null,0,1,0,null,1,null,null,null,0,null,1,0,null,null,0,0,0,null,null,null,0,null,1,null,0,0,0,null,1,null,1,null,0,null,0,null,1,null,0,null,1,null,1,0,0,null,1,1,1,null,1,null,1,null,0,null,0,0,1,1,1,0,0,1,0,null,1,1,0,null,0,null,1,null,0,null,1,null,null,null,0,null,null,null,0,null,0,null,1,null,null,null,1,0,0,null,1,null,null,null,0,null,1,null,1,0,null,null,1,0,1,null,0,null,0,0,0,null,null,null,null,null,0,null,1,null,1,null,1,null,0,0,null,null,1,1,0,null,null,null,0,null,0,null,0,null,0,0,null,null,null,null,1,null,0,null,0,1,0,null,0,0,1,null,0,null,1,null,1,null,1,null,1,null,0,null,0,1,0,null,0,1,1,null,1,null,0,null,1,null,1,null,0,null,0,null,1,1,1,null,0,0,null,null,0,1,1,null,0,null,null,null,null,null,1,0,1,null,null,null,null,null,null,null,0,null,1,1,null,null,null,null,1,1,0,null,0,null,0,1,1,0,0,null,1,1,0,0,1,null,0,null,1,0,null,null,null,null,0,0,1,null,1,null,null,0,null,null,1,1,0,1,1,null,null,null,null,null,0,null,1,null,0,null,null,null,0,null,null,null,0,1,null,null,null,null,0,null,1,null,1,null,1,null,0,0,0,0,1,null,1,null,0,null,1,null,1,null,0,1,1,0,1,0,1,null,0,null,0,null,0,null,0,0,0,null,0,null,0,1,0,null,0,null,0,null,0,null,0,1,0,null,null,1,null,1,0,null,null,null,1,null,0,1,0,null,0,null,0,0,1,null,1,null,0,null,1,1,0,null,1,null,1,null,1,null,0,null,null,null,null,null,null,null,0,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,1,null,null,null,null,null,null,null,0,null,1,0,1,null,0,0,1,0,0,null,0,0,0,0,1,null,1,null,0,null,1,null,1,null,1,0,1,null,0,null,1,null,0,null,0,1,null,null,0,1,1,null,0,null,1,null,null,null,1,1,0,null,1,null,0,null,1,null,1,null,0,1,0,null,null,0,null,null,0,null,1,0,null,null,null,null,0,null,null,1,null,null,0,null,0,null,1,null,1,null,0,null,0,null,1,null,0,null,0,null,null,null,null,null,0,1,0,null,null,null,1,null,0,null,1,null,0,null,1,null,1,0,1,null,1,0,null,null,0,null,0,null,0,null,0,null,1,null,1,1,0,null,0,null,1,1,0,null,0,null,0,null,1,null,1,null,1,0,0,null,1,null,1,null,1,1,1,null,1,null,1,null,0,null,null,null,null,null,0,null,1,null,0,1,1,0,0,null,null,null,1,0,0,0,0,null,null,null,0,null,null,null,null,null,0,null,0,null,0,null,1,null,1,null,null,null,0,null,0,1,null,null,0,null,0,null,null,null,null,null,null,null,1,null,null,null,1,null,1,null,null,null,0,null,0,null,null,null,0,0,0,null,null,null,null,null,null,null,1,null,0,null,null,null,null,null,0,null,0,null,0,null,0,0,1,null,0,null,1,null,1,0,0,null,0,null,1,null,1,null,null,null,null,null,0,null,1,null,1,null,null,null,0,0,null,null,null,null,1,null,1,0,1,0,1,null,1,0,0,null,1,1,0,null,1,null,1,1,1,1,null,0,0,null,null,null,0,0,null,null,1,null,0,null,null,null,null,null,1,null,0,null,null,null,1,null,1,null,0,null,null,null,0,null,0,null,1,null,null,null,null,null,1,null,1,null,0,1,0,null,0,null,1,null,null,null,0,null,null,null,1,null,1,null,1,1,1,1,0,null,null,null,null,null,1,null,1,null,null,null,0,null,1,1,0,null,null,null,0,1,1,1,0,null,1,null,0,null,1,null,null,0,1,1,null,null,0,null,null,null,0,null,1,null,0,1,0,1,null,null,1,null,0,null,0,0,null,null,null,null,null,null,0,1,0,1,1,null,0,0,1,0,null,null,1,null,null,null,1,null,1,null,0,null,1,null,1,null,null,null,0,null,null,null,null,null,null,null,0,null,0,null,null,null,null,0,null,null,1,null,null,0,0,null,0,1,null,1,0,1,0,null,null,1,0,0,0,null,0,null,null,null,1,null,1,0,null,null,0,null,1,1,1,null,null,null,null,null,null,null,0,null,null,null,1,null,null,null,0,null,0,null,0,null,null,null,null,null,null,null,1,null,0,null,1,null,null,null,null,null,null,null,1,null,1,null,1,0,1,0,1,null,null,null,0,null,null,null,null,null,null,null,0,null,null,1,null,null,1,null,null,null,null,null,null,null,1,null,1,null,null,null,1,1,0,null,1,0,null,null,1,null,0,0,1,null,1,null,null,null,null,1,null,null,1,0,0,null,null,0,1,null,null,null,0,null,null,null,1,1,1,null,0,null,1,1,1,null,null,1,0,null,null,null,null,0,1,null,1,0,null,null,null,null,0,null,0,0,0,null,null,null,0,1,1,null,0,null,null,null,null,null,1,null,null,1,null,null,1,null,null,null,null,1,null,null,0,null,0,0,1,null,null,null,null,null,1,1,null,null,null,null,null,null,null,null,0,0,null,null,0,null,null,null,null,null,0,null,0,null,1,null,0,null,1,null,0,null,null,null,null,null,null,null,null,null,null,null,1,null,null,null,null,0,null,null,0,null,1,null,null,null,null,null,1,null,1,null,0,null,null,null,0,null,1,null,0,null,null,null,null,null,null,0,null,null,null,1,null,null,1,null,null,null,null,null,1,0";
		Solution test=new Solution();
		System.out.println(test.sumRootToLeaf(stringToTreeNode(test_in)));
	}

}
