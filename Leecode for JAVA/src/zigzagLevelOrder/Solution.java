package zigzagLevelOrder;

/*
 * 二叉树的锯齿形层次遍历
 * 中序遍历，按层次保存数据
 * 将偶数层反转
 * AC
 * 2ms - 83.52%
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.TreeNode;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Order(res,root,0);
        for(int i=1;i<res.size();i+=2)
        {
        	Collections.reverse(res.get(i));
        }
        return res;
    }

	private void Order(List<List<Integer>> res, TreeNode node, int k) {
		if(node==null)
			return;
		if(k>=res.size())
			res.add(new ArrayList<Integer>());
		res.get(k).add(node.val);
		Order(res,node.left,k+1);
		Order(res,node.right,k+1);
	}
}
