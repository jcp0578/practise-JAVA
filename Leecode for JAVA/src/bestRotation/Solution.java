package bestRotation;

/*
 * title:798. 得分最高的最小轮调
 * url:https:https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/
 * time:  6ms - 83.33%
 * memory:51.7MB - 16.49%
 * 
 * AC
 * Refer：https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/solution/onde-shi-jian-fu-za-du-suan-fa-yi-ji-jie-xi-by-wan/
 * 
 */

public class Solution {
	public int bestRotation(int[] A) {
		int len = A.length;
		int[] save = new int[len];
		for (int i = 0; i < len; i++) {
			save[(i-A[i]+len + 1)%len] --;
		}
		int curNum = 0;
		int _max = curNum;
		
		int res = 0;
		for (int i = 1; i < len; i++) {
			curNum += (save[i] + 1);
			if (curNum > _max) {
				_max = curNum;
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
