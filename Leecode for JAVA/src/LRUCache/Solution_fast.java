package LRUCache;

import java.util.HashMap;

class LRUCache_fast {

	ListNode head;
	ListNode tail;
	HashMap<Integer, ListNode> hashMap;
	int capacity;

	class ListNode {
		int val;
		int key;
		ListNode pre;
		ListNode next;

		ListNode(int key, int val, ListNode pre, ListNode next) {
			this.key = key;
			this.val = val;
			this.pre = pre;
			this.next = next;
		}
	}

	public LRUCache_fast(int capacity) {
	        this.capacity = capacity;
	        head = new ListNode(0,0,null,null);
	        tail = new ListNode(0,0,null,null);
	        head.next  = tail;
	        tail.pre = head;
	       hashMap = new HashMap<Integer,ListNode>();
	    }

	public int get(int key) {
		if (hashMap.get(key) != null) {
			ListNode node = hashMap.get(key);
			removeCurrentNode(node);
			moveToHead(node);
			return node.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (hashMap.size() == capacity && hashMap.get(key) == null) {
			removeTail();
		}
		if (hashMap.get(key) != null) {
			ListNode node = hashMap.get(key);
			node.val = value;
			removeCurrentNode(node);
			moveToHead(node);
		} else {
			ListNode node = new ListNode(key, value, null, null);
			hashMap.put(key, node);
			moveToHead(node);
		}

	}

	public void removeCurrentNode(ListNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void moveToHead(ListNode node) {
		head.next.pre = node;
		node.next = head.next;
		head.next = node;
		node.pre = head;
	}

	public void removeTail() {
		hashMap.remove(tail.pre.key);
		ListNode node1 = tail.pre.pre;
		node1.next = tail;
		tail.pre = node1;
	}
}
