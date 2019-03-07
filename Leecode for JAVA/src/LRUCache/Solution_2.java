package LRUCache;

/*
 * 
 * AC but not good
 * 
 */
import java.util.HashMap;
import java.util.Map;

public class Solution_2 {
	Map<Integer, D_ListNode> map_t;
	D_ListNode head, end, notfind;
	int Max_Size = 0;

	public Solution_2(int capacity) {
		map_t = new HashMap<Integer, D_ListNode>();
		Max_Size = capacity;
		notfind = new D_ListNode(0,-1);
		head = new D_ListNode(0,-2);
		end = new D_ListNode(0,-3);
		head.next = end;
		end.pre = head;
	}

	public int get(int key) {
		D_ListNode find_t = map_t.getOrDefault(key, notfind);
		if (find_t.val != -1) {
			MovetoHead(find_t);
		}
		return find_t.val;
	}

	public void put(int key, int value) {
		D_ListNode find_t = map_t.getOrDefault(key, notfind);
		if (find_t.val != -1) {
			find_t.val = value;
			MovetoHead(find_t);
		} else {
			if (map_t.size() >=Max_Size) {
				DelEndNode();
			}

			D_ListNode newnode = new D_ListNode(key,value);
			MovetoHead(newnode);
			map_t.put(key, newnode);
		}
	}

	void MovetoHead(D_ListNode node) {
		if (node.pre != null && node.pre.val == -2)// 已连接头节点
		{

		} else {
			if (node.pre != null)
				node.pre.next = node.next;
			if (node.next != null)
				node.next.pre = node.pre;

			head.next.pre = node;
			node.next = head.next;

			node.pre = head;
			head.next = node;
		}
	}

	void DelEndNode() {
		map_t.remove(end.pre.key);
		end.pre.pre.next = end;
		end.pre = end.pre.pre;
	}

	public static void main(String[] args) {

		Solution_2 cache = new Solution_2(2);
		cache.put(1, 1);
		cache.put(2, 2);

		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}
}

class D_ListNode {
	int val;
	int key;
	D_ListNode pre;
	D_ListNode next;

	D_ListNode(int a, int b) {
		key = a;
		val = b;
	}
}