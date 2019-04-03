package allOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * 全 O(1) 的数据结构
 * AC but slow
 * 161ms - 10.30%
 * 
 */

class AllOne {
	HashMap<String, Integer> map;
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	HashMap<Integer, ArrayList<String>> save;

	/** Initialize your data structure here. */
	public AllOne() {
		map = new HashMap<>();
		minHeap = new PriorityQueue<>((a, b) -> (a - b));
		maxHeap = new PriorityQueue<>((a, b) -> (b - a));
		save = new HashMap<>();
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		map.put(key, map.getOrDefault(key, 0) + 1);
		int val = map.get(key);
		if (save.containsKey(val)) {
			save.get(val).add(key);
		} else {
			ArrayList<String> add_t = new ArrayList<>();
			add_t.add(key);
			save.put(val, add_t);
			minHeap.add(val);
			maxHeap.add(val);
		}
		if (val != 1) {
			ArrayList<String> temp_list = save.get(val - 1);
			if (temp_list.size() == 1) {
				save.remove(val - 1);
				minHeap.remove(val - 1);
				maxHeap.remove(val - 1);
			} else {
				temp_list.remove(key);
			}
		}
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the data
	 * structure.
	 */
	public void dec(String key) {
		if (map.containsKey(key)) {
			int val = map.get(key);
			if (val == 1) {
				map.remove(key);
			} else {
				map.put(key, val - 1);
				if (save.containsKey(val - 1)) {
					save.get(val - 1).add(key);
				} else {
					ArrayList<String> add_t = new ArrayList<>();
					add_t.add(key);
					save.put(val - 1, add_t);
					minHeap.add(val - 1);
					maxHeap.add(val - 1);
				}
			}
			ArrayList<String> temp_list = save.get(val);
			if (temp_list.size() == 1) {
				save.remove(val);
				minHeap.remove(val);
				maxHeap.remove(val);
			} else {
				temp_list.remove(key);
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if (maxHeap.peek() == null)
			return "";
		return save.get(maxHeap.peek()).get(0);
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if (minHeap.peek() == null)
			return "";
		return save.get(minHeap.peek()).get(0);
	}

	public static void main(String[] args) {

		AllOne obj = new AllOne();
		obj.inc("1");
		obj.inc("1");
		obj.inc("2");
//		obj.dec("1");
//		obj.dec("1");
		obj.dec("2");
		System.out.println(obj.getMaxKey());
		System.out.println(obj.getMinKey());

	}
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new
 * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
