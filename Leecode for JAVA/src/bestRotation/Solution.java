package bestRotation;

/*
 * title:798. 得分最高的最小轮调
 * url:https:https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/
 * time:  
 * memory:
 * 
 * Time Out
 * 
 * 
 */

public class Solution {
	public int bestRotation(int[] A) {
		int len = A.length;
		int[] save = new int[len];
		for (int i = 0; i < len; i++) {
			if (A[i] <= i) {
				for (int j = 0; j <= (i - A[i]); j++) {
					save[j]++;
				}
				for (int j = i + 1; j < len; j++) {
					save[j]++;
				}
			} else {
				for (int j = i + 1; j <= (i + len - A[i]); j++) {
					save[j]++;
				}
			}
		}
		int _max = save[0];
		int res = 0;
		for (int i = 0; i < len; i++) {
			if (save[i] > _max) {
				_max = save[i];
				res = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test_in = { 1, 3, 0, 2, 4 };
		Solution test = new Solution();
		System.out.println(test.bestRotation(test_in));

	}

}
