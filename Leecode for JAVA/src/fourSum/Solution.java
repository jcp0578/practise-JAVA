package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * 四数之和
 * AC but too slow
 * 664ms - 0%
 * 
 */
public class Solution {
	int _target;
	HashSet<List<Integer>> _save_set;

	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> ret = new ArrayList<>();
		if (nums == null)
			return ret;
		Arrays.sort(nums);

		int[] index = new int[4];
		Arrays.fill(index, -1);

		this._target = target;
		
		this._save_set =new HashSet<>();
		
		Deal(index, nums, 0, 0);
	
		ret.addAll(this._save_set);
	
		return ret;

	}

	private void Deal(int[] index, int[] nums, int sum_t, int k) {
		if (k == 4) {
			if (sum_t == this._target) {
				ArrayList<Integer> add_t = new ArrayList<Integer>();
				for (int t : index)
					add_t.add(nums[t]);
				this._save_set.add(add_t);
				return;
			}

		} else {
			for (int i = ((k == 0) ? 0 : index[k - 1] + 1); i < nums.length; i++) {
				index[k] = i;
				int sum_temp = sum_t + nums[i];
				Deal(index, nums, sum_temp, k + 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] test_in = { 1,-2,-5,-4,-3,3,3,5 };
		int target = -11;
		Solution test = new Solution();
		System.out.println(test.fourSum(test_in, target));
	}

}
