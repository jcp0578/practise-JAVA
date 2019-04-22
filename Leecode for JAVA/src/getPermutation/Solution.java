package getPermutation;

/*
 * 第k个排列
 * AC
 * 2ms - 100%
 * 
 */
public class Solution {
	public String getPermutation(int n, int k) {
		int[] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
		boolean[] visit = new boolean[n];
		StringBuffer res = new StringBuffer();
		int temp = n;
		while (temp > 0) {
			int step = (k - 1) / factorial[temp - 1];
			k = k - step * factorial[temp - 1];
			temp--;
			char out_temp = '0';
			for (int i = 0; i < n; i++) {
				if (visit[i])
					continue;
				if (step == 0) {
					out_temp = (char) (i + '1');
					visit[i] = true;
					break;
				} else
					step--;
			}
			res.append(out_temp);
		}
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;
			else
				res.append((char) (i + '1'));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		int test_n = 5;
		int test_k = 24;
		Solution test = new Solution();
		System.out.println(test.getPermutation(test_n, test_k));

	}

}
