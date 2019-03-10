package MaxProduct;

import java.util.Scanner;

/*
 * 最大乘积
 * https://www.nowcoder.com/practice/5f29c72b1ae14d92b9c3fa03a037ac5f?tpId=90&tqId=30776&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 */
public class Solution {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner readScanner = new Scanner(System.in);
		while (readScanner.hasNextLine()) {
			int n = readScanner.nextInt();
			long[] max_p = new long[3];
			long[] min_n = new long[2];
			for (int i = 0; i < n; i++) {
				long read_temp = readScanner.nextLong();
				if (read_temp > 0) {
					if (read_temp > max_p[0]) {
						max_p[2] = max_p[1];
						max_p[1] = max_p[0];
						max_p[0] = read_temp;
					} else if (read_temp > max_p[1]) {
						max_p[2] = max_p[1];
						max_p[1] = read_temp;
					} else if (read_temp > max_p[2]) {
						max_p[2] = read_temp;
					} else {
					}
				} else if (read_temp < 0) {
					if (read_temp < min_n[0]) {
						min_n[1] = min_n[0];
						min_n[0] = read_temp;
					} else if (read_temp < min_n[1]) {
						min_n[1] = read_temp;
					} else {
					}
				}
			}
			System.out.println(Math.max(max_p[2] * max_p[1] * max_p[0], min_n[0] * min_n[1] * max_p[0]));
		}
		readScanner.close();
	}

}
