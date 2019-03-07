package grayCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 89. 格雷编码
 * https://leetcode-cn.com/problems/gray-code/submissions/
 * AC but too slow -17ms
 * https://leetcode-cn.com/submissions/detail/13819316/
 */
public class Solution {

	public static List<Integer> grayCode(int n) {
		List<Integer> out_t = new ArrayList<Integer>();
		if (n > 1) {
			out_t = grayCode(n - 1);
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = out_t.size() - 1; i >= 0; i--) {
				temp.add((1 << (n - 1)) + out_t.get(i));
			}
			out_t.addAll(temp);
		} else if (n == 1) {
			out_t.add(0);
			out_t.add(1);
		} else {
			out_t.add(0);
		}

		return out_t;
	}

	public static void main(String[] args) {
		int nums_in = 3;
		System.out.println(grayCode(nums_in));
	}
}
