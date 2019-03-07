package subsets;

import java.util.ArrayList;
import java.util.List;

/*
 * DFS
 */
public class Solution_fast {
	    static List<List<Integer>> ret = new ArrayList<>();

	    public static List<List<Integer>> subsets(int[] nums) {
	        dfs(new ArrayList<>(), nums, 0);
	        return ret;
	    }

	    static void dfs(List<Integer> list, int[] nums, int i) {
	        if (i == nums.length) {
	            ret.add(new ArrayList<>(list));
	            return;
	        }
	        for (int j = i; j < nums.length; j++) {
	            list.add(nums[j]);
	            //使用j+1,避免出现重复
	            dfs(list, nums, j + 1);
	            list.remove(list.size() - 1);
	        }
	        dfs(list, nums, nums.length);
	    }
	    /**
	     * TODO:解法2:遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
	     */
	    public static void main(String[] args) {
			int[] nums_in= {1,2,3};
			System.out.println(subsets(nums_in));
		}
	}
