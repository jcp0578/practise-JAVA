package bstFromPreorder;

import util.TreeNode;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
    	int len=preorder.length;
    	if(len<=0)
    		return null;
    	return outPreorder(preorder,0,len-1);
    }
    public TreeNode outPreorder(int[] preorder,int start,int end)
    {
    	if(start>end)
    		return null;
    	TreeNode root=new TreeNode(preorder[start]);
    	if(start==end)
    		return root;
    	int i=start+1;
    	for(i=start+1;i<=end;i++)
    	{
    		if(preorder[i]>preorder[start])
    			break;
    	}
    	root.left=outPreorder(preorder,start+1,i-1);
    	root.left=outPreorder(preorder,i,end);
		return root;
    	
    }
}
