package containsDuplicate;

import java.util.HashMap;
import java.util.Map;

/*
 * 存在重复元素
 * 
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/264/array/1129/
 *  
 *  AC 
 *  利用HashMap建立索引
 */
public class solution {
	public static boolean containsDuplicate(int[] nums) {
		if (nums.length <= 1)
			return false;
		HashMap<Integer, Integer> count_map = new HashMap<>();
		for (int num : nums) {
			try {
				if (count_map.get(num) == null) {
					count_map.put(num, 1);
				} else
					return true;
			} catch (Exception e) {
				count_map.put(num, 1);
				// System.out.println(e.getMessage());
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] test_in = {};
		System.out.println(containsDuplicate(test_in));
		int[] test_in2 = { 1 };
		System.out.println(containsDuplicate(test_in2));
		int[] test_in3 = { 1, 2, 3 };
		System.out.println(containsDuplicate(test_in3));
		int[] test_in4 = { 1, 2, 3, 2 };
		System.out.println(containsDuplicate(test_in4));

	}

}
