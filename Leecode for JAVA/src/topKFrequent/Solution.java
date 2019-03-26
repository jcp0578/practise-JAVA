package topKFrequent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/*
 * 前K个高频元素
 * HashMap统计，后根据value排序
 * 
 * AC but have bug
 * 当元素出现频率相同时，会多输出
 * 28ms - 84.16%
 * 
 */
public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		ArrayList<Integer> ret = new ArrayList<>();
		Map<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
		}
		int[] frequency = new int[nums.length + 1];
		for (Integer t : count.values()) {
			frequency[t]++;
		}
		int threshold = nums.length;
		int index_t = nums.length;
		while (k > 0) {
			k -= frequency[index_t];
			threshold = index_t--;
		}
		for (Integer key_t : count.keySet()) {
			if (count.get(key_t) >= threshold)
				ret.add(key_t);
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] test_in = { 1, 1, 1, 2, 2, 2, 3, 3, 3 };
		int k = 2;
		Solution test = new Solution();
		for (int t : test.topKFrequent(test_in, k)) {
			System.out.print(t);
			System.out.print(" ,");
		}

	}

}
