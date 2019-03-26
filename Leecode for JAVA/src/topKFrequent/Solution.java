package topKFrequent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/*
 * 前K个高频元素
 * HashMap统计，后根据value排序
 * 
 * AC but slow
 * 95ms - 19.41%
 * 
 */
public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		ArrayList<Integer> ret = new ArrayList<>();
		Map<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
		}
		
        // 将map.entrySet()转换成list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        // 通过比较器来实现排序
        Collections.sort(list, (a,b)->(b.getValue()-a.getValue()));	
		for(int i=0;i<list.size() && i<k;i++)
		{
			ret.add(list.get(i).getKey());
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] test_in = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		Solution test = new Solution();
		for (int t : test.topKFrequent(test_in, k)) {
			System.out.print(t);
			System.out.print(" ,");
		}

	}

}
