package kthSmallestByMatrix;

import java.util.PriorityQueue;

/*
 * 有序矩阵中第K小的元素
 * 利用统计比mid小的个数进行二分查找
 * AC
 * 1ms - 98.97%
 * 
 */
public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int len_y = matrix.length;
//        if(len_y==0)
//        	return -1;
		int len_x = matrix[0].length;
//        if(len_x==0)
//        	return -1;
		int lo = matrix[0][0];
		int hi = matrix[len_y - 1][len_x - 1];
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (k > lessMid(matrix, mid)) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
	}

	private int lessMid(int[][] matrix, int mid) {
		int len_y = matrix.length;
		int len_x = matrix[0].length;
		int ret = 0;
		for (int i = len_y - 1, j = 0; (i >= 0) && (j < len_x);) {
			if (mid >= matrix[i][j]) {
				ret += (i + 1);
				j++;
			} else {
				i--;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[][] test_in = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int k = 8;
		Solution test = new Solution();
		System.out.println(test.kthSmallest(test_in, k));
	}
}
