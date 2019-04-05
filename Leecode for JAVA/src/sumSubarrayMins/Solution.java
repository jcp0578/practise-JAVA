package sumSubarrayMins;

/*
 * 子数组的最小值之和
 * 
 * 时间复杂度O(N^2) 
 * out time
 */

public class Solution {
	public int sumSubarrayMins(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += deal(A, i);
			if (sum >= (1000000007)) {
				sum %= (1000000007);
			}
		}
		return sum;
	}

	private int deal(int[] a, int start) {
		int sum = 0;
		int min_t = a[start];
		for (int i = start; i < a.length; i++) {
			if (min_t > a[i]) {
				min_t = a[i];
			}
			sum += min_t;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] test_in = {1,2 };
		Solution test = new Solution();
		System.out.println(test.sumSubarrayMins(test_in));
	}
}
