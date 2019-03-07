package generateMatrix;

public class Solution_fast {

	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int hmax = n - 1, hmin = 0, lmax = n - 1, lmin = 0;
		int i = 0, j = 0;
		int temp = 1;
		while (hmax >= hmin && lmax >= lmin) {

			while (j <= lmax)
				result[i][j++] = temp++;
			hmin++;
			j--;
			i++;

			while (i <= hmax)
				result[i++][j] = temp++;
			lmax--;
			i--;
			j--;

			while (j >= lmin)
				result[i][j--] = temp++;
			hmax--;
			j++;
			i--;

			while (i >= hmin)
				result[i--][j] = temp++;
			lmin++;
			i++;
			j++;

		}
		return result;
	}
}
