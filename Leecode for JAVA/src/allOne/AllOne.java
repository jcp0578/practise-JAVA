package allOne;

import java.util.HashMap;

/*
 * 全 O(1) 的数据结构
 * AC but slow
 * 150ms - 40.61%
 * 
 */

class AllOne {
	HashMap<String, Integer> map;

	/** Initialize your data structure here. */
	public AllOne() {
		map = new HashMap<>();
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		map.put(key, map.getOrDefault(key, 0) + 1);
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the data
	 * structure.
	 */
	public void dec(String key) {
		if (map.containsKey(key) && map.get(key) != 0) {
			map.put(key, map.get(key) - 1);
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		int max_t = 0;
		String out = "";
		for (String t : map.keySet()) {
			if (map.get(t) > max_t) {
				out = t;
				max_t = map.get(t);
			}
		}
		return out;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		int min_t = Integer.MAX_VALUE;
		String out = "";
		for (String t : map.keySet()) {
			int val = map.get(t);
			if (val != 0 && val < min_t) {
				out = t;
				min_t = val;
			}
		}
		return out;
	}

	public static void main(String[] args) {

		AllOne obj = new AllOne();
		obj.dec("hello");
//		obj.inc("1");
//		obj.inc("2");
//		obj.dec("1");
//		obj.dec("1");
//		obj.dec("2");
		System.out.println(obj.getMaxKey());
		System.out.println(obj.getMinKey());

	}
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new
 * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
