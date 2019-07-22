package isSymmetric;

import java.util.ArrayList;

import util.TreeNode;
import util.Wrapper;

/*
 * 对称二叉树
 * AC
 * 1ms - 99.61%
 */
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode p, TreeNode q) {
	    if(p == null || q == null)
	        return p == q;
	    if(p.val != q.val)
	        return false;
            return (isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left));//左子树先访问左节点，右子树先访问右节点
    }

	public static void main(String[] args) {
		String test_in_str = "[1,2,2,2,null,2]";
		TreeNode test_in = Wrapper.stringToTreeNode(test_in_str);
		Solution test = new Solution();
		System.out.println(test.isSymmetric(test_in));

	}

}
