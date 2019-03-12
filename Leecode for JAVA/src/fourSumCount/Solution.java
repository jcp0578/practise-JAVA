package fourSumCount;

import java.util.HashMap;
/*
 * 四数相加 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/268/hash-map/1163/
 * 
 * AC but too slow 
 * 336ms 6.04%
 */
public class Solution {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int len = A.length;
		if (len == 0)
			return 0;
		HashMap<Integer, Integer> sum_ab, sum_cd;
		sum_ab = new HashMap<Integer, Integer>();
		sum_cd = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int key_temp;
				key_temp = A[i] + B[j];
				sum_ab.put(key_temp, sum_ab.getOrDefault(key_temp, 0) + 1);
				key_temp = C[i] + D[j];
				sum_cd.put(key_temp, sum_cd.getOrDefault(key_temp, 0) + 1);
			}
		}
		int out_t = 0;
		for (Integer key_t : sum_ab.keySet()) {
			out_t += sum_ab.getOrDefault(key_t, 0) * sum_cd.getOrDefault(-key_t, 0);
		}
		return out_t;
	}

	public static void main(String[] args) {
//		int[] a= {1,2},b= {-2,-1},c= {-1,2},d= {0,2};
		int[] a = { 1 }, b = { -2 }, c = { -1 }, d = { 0 };
		Solution test = new Solution();
		System.out.println(test.fourSumCount(a, b, c, d));

	}

}
