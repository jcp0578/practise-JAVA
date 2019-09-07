package checkRecord;

import java.util.Arrays;

/*
 *state[j]  i:index j:state
 *A     0
 *L     1
 *LL    2
 *P     3
 *(A)L  4
 *(A)LL 5 
 *(A)P  6
 *
 */

/*
 *  titel :  学生出勤记录 II
 *  url : https://leetcode-cn.com/problems/student-attendance-record-ii/submissions/
 *  time: 48ms - 79.31%
 *  memory: 33.7MB - 100%
 *  AC
 * 
 */
public class Solution {
	final long mod = 1000000000 + 7;

	public int checkRecord(int n) {
		int[] state = new int[7];
		int[] state_last = new int[7];
		state[0] = 1;
		state[1] = 1;
		state[2] = 0;
		state[3] = 1;
		state[4] = 0;
		state[5] = 0;
		state[6] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 7; j++) {
				state_last[j] = state[j];
			}
			state[0] = (int) (((long) state_last[1] + state_last[2] + state_last[3]) % mod);
			state[1] = state_last[3];
			state[2] = state_last[1];
			state[3] = state[0];
			state[4] = (int) (((long) state_last[0] + state_last[6]) % mod);
			state[5] = state_last[4];
			state[6] = (int) (((long) state[4] + state_last[4] + state_last[5]) % mod);

		}

		/* out */
		long res = 0;
		for (int i = 0; i < 7; i++) {
			res += state[i];
		}
		return (int) (res % mod);
	}

	public static void main(String[] args) {
		int test_in = 100000;
		Solution test = new Solution();
		System.out.println(test.checkRecord(test_in));

	}

}
