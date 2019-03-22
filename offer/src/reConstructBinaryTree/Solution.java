package reConstructBinaryTree;

/*
 * 重建二叉树
 * AC
 */
public class Solution {
	int[] pre_g,in_g;
	int root_index=0;
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		int len=pre.length;
		if(len==0)
			return null;
		if(len!=in.length)
			return null;
		pre_g=pre;
		in_g=in;
		root_index=0;
		TreeNode root=reTree(0,len-1);
		return root;
	}
	private TreeNode reTree(int start, int end) {
		if(start>end)
			return null;
		else if(start==end)
			return new TreeNode(pre_g[root_index++]);
		
		int i=0;
		for(i=start;i<=end;i++)
		{
			if(in_g[i]==pre_g[root_index])
			{
				break;
			}
		}
		if(i>end)//error
			return null;
		TreeNode root_t =new TreeNode(in_g[i]);
		root_index++;
		root_t.left=reTree(start,i-1);
		root_t.right=reTree(i+1,end);
		return root_t;
	}
	public static void main(String[] args) {
		int [] pre= {1,2,4,7,3,5,6,8};
		int [] in= {4,7,2,1,5,3,8,6};
		System.out.println(reConstructBinaryTree(pre,in));

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
