package generateMatrix;
/*
 * 59. 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/submissions/
 * 
 * AC 2ms
 * https://leetcode-cn.com/submissions/detail/13881820/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static int[][] generateMatrix(int n) {
		int[][] out_t = new int[n][n];

		int out_num = 1;
		int k=0;
		while(out_num<=n*n)
		{
			for(int i=k;i<n-k;i++)
				out_t[k][i]=out_num++;
			for(int j=k+1;j<n-k;j++)
				out_t[j][n-1-k]=out_num++;
			for(int i=n-2-k;i>=k;i--)
				out_t[n-1-k][i]=out_num++;
			for(int j=n-2-k;j>k;j--)
				out_t[j][k]=out_num++;
			k++;
		}

		return out_t;
	}

	public static void main(String[] args) {
		int nums_in = 0;
		int[][] nums_out = generateMatrix(nums_in);
		for (int[] temp : nums_out) {
			System.out.println(Arrays.toString(temp));
		}

	}
}
