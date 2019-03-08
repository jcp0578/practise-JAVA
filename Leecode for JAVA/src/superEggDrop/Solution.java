package superEggDrop;

/*
 * 鸡蛋掉落
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/261/before-you-start/1110/
 * 
 * 动态规划
 * 
 * 
 * AC but out time
 * 
 */
public class Solution {
//	public static int superEggDrop(int K, int N) {
//	
//	
//	}
	// AC but out time
	public static int superEggDrop(int K, int N) {
		if (N <= 0)
			return 0;
		else if (N == 1)
			return 1;
		else if (N == 2)
			return 2;
		if (K <= 1)
			return N;

		int[] last_temp = new int[N];
		for (int i = 0; i < N; i++)
			last_temp[i] = i + 1;

		int[] now_temp = new int[N];
		if (N > 0)
			now_temp[0] = 1;
		if (N > 1)
			now_temp[1] = 2;
		int find_start = 2;
		int last_find_start = 2;
		for (int j = 0; j < K - 1 && find_start < N; j++) {
			
			for (int i = last_find_start; i < find_start; i++) {
				now_temp[i] = last_temp[i];
			}
			last_find_start = find_start;

			for (int i = find_start; i < N; i++) {
				int min_temp = last_temp[i];
				for (int l = 0; l < i - 1; l++) {
					int temp = Math.max(last_temp[l], now_temp[i - 2 - l]) + 1;
					if (temp < min_temp)
						min_temp = temp;
				}
				now_temp[i] = min_temp;
				if (i == find_start) {
					if ((1 << (now_temp[i] - 1)) <= (i + 1)) {
						find_start = i + 1;
					}
				}
			}
			int[] swap_temp = last_temp;
			last_temp = now_temp;
			now_temp = swap_temp;
		}

		return last_temp[N - 1];

	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		System.out.println(superEggDrop(6, 6));// 3
//		System.out.println(superEggDrop(2, 6));// 3
//		System.out.println(superEggDrop(1,6));//6
//		System.out.println(superEggDrop(1,2));//2
//		System.out.println(superEggDrop(2,2));//2
//		System.out.println(superEggDrop(3,14));//4
//		System.out.println(superEggDrop(2,4));//3
//		System.out.println(superEggDrop(0,6));//6
//		System.out.println(superEggDrop(2,9));//4
//		System.out.println(superEggDrop(2, 7));// 4
//		System.out.println(superEggDrop(2, 11));// 5
		System.out.println(superEggDrop(100, 100));
		System.out.println(superEggDrop(100, 8192));
		System.out.println(superEggDrop(100, 10000));
	}

}
