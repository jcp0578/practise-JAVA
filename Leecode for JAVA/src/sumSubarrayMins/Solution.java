package sumSubarrayMins;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 子数组的最小值之和
 * 
 * 查找以A[i]为最小值的子数组的左右边界
 * 时间复杂度O(N) 
 * AC
 * 79ms - 93.06%
 */

public class Solution {
	public int sumSubarrayMins(int[] A) {
		if (A == null)
			return 0;
		int len = A.length;
		int[] left = new int[len];
		int[] right = new int[len];
		// left
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < len; i++) {
			if (stack.isEmpty() || A[i] > A[stack.peek()])
				left[i] = i;
			else {
				while (!stack.isEmpty() && A[i] <= A[stack.peek()])
					stack.pop();
				if (stack.isEmpty())
					left[i] = 0;
				else
					left[i] = stack.peek() + 1;
			}
			stack.push(i);
		}
		// right
		stack.clear();
		for (int i = len - 1; i >= 0; i--) {
			if (stack.isEmpty() || A[i] >= A[stack.peek()])
				right[i] = i;
			else {
				while (!stack.isEmpty() && A[i] < A[stack.peek()])
					stack.pop();
				if (stack.isEmpty())
					right[i] = len - 1;
				else
					right[i] = stack.peek() - 1;
			}
			stack.push(i);
		}
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i] * (i - left[i] + 1) * (right[i] - i + 1);
			if (sum >= 1000000007)
				sum %= 1000000007;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] test_in = { 3, 3, 3 };
		Solution test = new Solution();
		System.out.println(test.sumSubarrayMins(test_in));
	}
}
