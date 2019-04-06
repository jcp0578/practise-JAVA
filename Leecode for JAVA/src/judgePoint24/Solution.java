package judgePoint24;

/*
 * 24点游戏
 * 存在bug
 * 
 */
public class Solution {
	public boolean judgePoint24(int[] nums) {
		boolean[] visit = new boolean[4];
		for (int i = 0; i < 4; i++) {
			double last = nums[i];
			visit[i] = true;
			if (DFS(nums, visit, last))
				return true;
			visit[i] = false;
		}
		return false;

	}

	private boolean DFS(int[] nums, boolean[] visit, double last) {
		boolean over_falg = true;
		for (int i = 0; i < 4; i++) {
			double temp = last;
			if (visit[i])
				continue;
			over_falg = false;
			visit[i] = true;
			temp = last;
			temp += nums[i];
			if (DFS(nums, visit, temp))
				return true;

			temp = last;
			temp -= nums[i];
			if (DFS(nums, visit, temp))
				return true;

			temp = last;
			temp = nums[i] - temp;
			if (DFS(nums, visit, temp))
				return true;

			temp = last;
			temp *= nums[i];
			if (DFS(nums, visit, temp))
				return true;
			if (nums[i] != 0) {
				temp = last;
				temp /= nums[i];
				if (DFS(nums, visit, temp))
					return true;
			}
			if (last != 0) {
				temp = last;
				temp = nums[i] / last;
				if (DFS(nums, visit, temp))
					return true;
			}
			visit[i] = false;
		}
		if (over_falg) {
			if (Math.abs(last - 24.0) < (1e-6))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] test_in = { 1, 9,1,2 };
		Solution test = new Solution();
		System.out.println(test.judgePoint24(test_in));

	}

}
