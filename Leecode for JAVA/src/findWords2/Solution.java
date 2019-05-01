package findWords2;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
 * 单词搜索 II
 * 前缀树保存
 * 回溯法遍历
 * TreeSet用于保存
 * AC but slow
 * 232ms 22.71%
 * 
 */
public class Solution {
	TreeSet<String> ret;
	Trie trie;
	int len_x;
	int len_y;
	char[][] _board;
    public List<String> findWords(char[][] board, String[] words) {
    	this.trie=new Trie();
    	this.ret=new TreeSet<>();
    	List<String> out=new ArrayList<>();
    	this._board=board;
    	for(String word:words)
    	{
    		this.trie.insert(word);
    	}
    	this.len_y=board.length;
    	if(this.len_y==0)
    		return out;
    	this.len_x=board[0].length;
    	if(this.len_x==0)
    		return out;
    	boolean[][] flag=new boolean[this.len_y][this.len_x];
    	StringBuffer temp=new StringBuffer();
    	for(int i=0;i<this.len_y;i++)
    	{
    		for(int j=0;j<this.len_x;j++)
    		{
    			find(i,j,flag,temp);
    		}
    	}
    	for(String str:this.ret)
    		out.add(str);
    	return out;
    }
	private void find(int y, int x, boolean[][] flag, StringBuffer temp) {
		if(y<0 || y>=this.len_y)
			return;
		if(x<0 || x>=this.len_x)
			return;
		if(flag[y][x])
			return;
		
		StringBuffer t=new StringBuffer(temp);
		t.append(this._board[y][x]);
		String now_str=t.toString();
		
		if(this.trie.search(now_str))
			this.ret.add(now_str);
		if(this.trie.startsWith(now_str)==false)
			return;		
		
		flag[y][x]=true;
		find(y+1,x,flag,t);
		find(y-1,x,flag,t);
		find(y,x+1,flag,t);
		find(y,x-1,flag,t);
		flag[y][x]=false;
		return;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] words = {"oath","pea","eat","rain"};
		char[][] board =
				{
				  {'o','a','a','n'},
				  {'e','t','a','e'},
				  {'i','h','k','r'},
				  {'e','a','t','v'}
				};
		Solution test =new Solution();
		System.out.println(test.findWords(board, words ));
	}

}

class Trie {
	class TreeNode {
		char val;
		boolean end_flag = false;
		TreeNode[] child;

		TreeNode(char val) {
			this.val = val;
			this.child = new TreeNode[26];
		}

		void setEnd() {
			this.end_flag = true;
		}
	}

	TreeNode root;

	/** Initialize your data structure here. */
	public Trie() {
		this.root = new TreeNode('0');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TreeNode t = this.root;
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			TreeNode newNode = t.child[temp - 'a'];
			if (newNode == null) {
				newNode = new TreeNode(temp);
				t.child[temp - 'a'] = newNode;
			}
			t = newNode;
		}
		t.setEnd();
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TreeNode t = this.root;
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			TreeNode nextNode = t.child[temp - 'a'];
			if (nextNode == null)
				return false;
			t = nextNode;
		}
		if (t.end_flag)
			return true;
		else
			return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TreeNode t = this.root;
		for (int i = 0; i < prefix.length(); i++) {
			char temp = prefix.charAt(i);
			TreeNode nextNode = t.child[temp - 'a'];
			if (nextNode == null)
				return false;
			t = nextNode;
		}
		return true;
	}
}