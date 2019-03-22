package Trie;

import java.util.ArrayList;

/*
 * 实现 Trie (前缀树)
 * 
 * AC but slow
 * 
 */
public class Trie {
	class TreeNode
	{
		char val;
		boolean over_flag=false;
		ArrayList<TreeNode> child;
		TreeNode(char val)
		{
			this.val=val;
			this.child=new ArrayList<TreeNode>();
		}
	}
	TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
    	this.root=new TreeNode('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TreeNode t=this.root;
        for(int i=0;i<word.length();i++)
        {
        	char temp=word.charAt(i);
        	int j=0;
        	int len=t.child.size();
        	for(;j<len;j++)
        	{
            	if(t.child.get(j).val==temp)
            	{
            		t=t.child.get(j);
            		break;
            	}        		
        	}
        	if(j==len)
        	{
        		TreeNode add_t=new TreeNode(temp);
        		t.child.add(add_t);
        		t=add_t;
        	}
        }
        t.over_flag=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TreeNode t=this.root;
        for(int i=0;i<word.length();i++)
        {
        	char temp=word.charAt(i);
        	int j=0;
        	int len=t.child.size();
        	for(;j<len;j++)
        	{
            	if(t.child.get(j).val==temp)
            	{
            		t=t.child.get(j);
            		break;
            	}        		
        	}
        	if(j==len)
        	{
        		return false;
        	}
        }
        if(t.over_flag)
        	return true;
        else
        	return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TreeNode t=this.root;
        for(int i=0;i<prefix.length();i++)
        {
        	char temp=prefix.charAt(i);
        	int j=0;
        	int len=t.child.size();
        	for(;j<len;j++)
        	{
            	if(t.child.get(j).val==temp)
            	{
            		t=t.child.get(j);
            		break;
            	}        		
        	}
        	if(j==len)
        	{
        		return false;
        	}
        }
    	return true;      
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Trie trie = new Trie();

		trie.insert("a");
		System.out.println(trie.search("a"));   // 返回 true
		System.out.println(trie.search("a"));     // 返回 false
		System.out.println(trie.startsWith("a")); // 返回 true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // 返回 true

	}

}
