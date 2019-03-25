package countSmaller;

import java.util.ArrayList;
import java.util.List;

/*
   *  计算右侧小于当前元素的个数
 * out time
 * 
 */
public class Solution {
	public List<Integer> countSmaller(int[] nums) {
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i])
					count++;
			}
			ret.add(count);
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] test_in = { 1, 3, 2, 2, 2, 1 };
		Solution test = new Solution();
		System.out.println(test.countSmaller(test_in));
	}

}
