package Trie;

import java.util.ArrayList;

/*
 * 实现 Trie (前缀树)
 * 利用数组进行查询
 * AC
 * 180ms - 55.21%
 */
public class Trie {
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

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Trie trie = new Trie();

		trie.insert("a");
		System.out.println(trie.search("app")); // 返回 true
		System.out.println(trie.search("a")); // 返回 false
		System.out.println(trie.startsWith("a")); // 返回 true
		trie.insert("app");
		System.out.println(trie.search("app")); // 返回 true

	}

}
