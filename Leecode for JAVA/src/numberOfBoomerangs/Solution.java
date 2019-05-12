package numberOfBoomerangs;

import java.util.HashMap;

/*
 * 回旋镖的数量
 * AC
 * 233ms - 66.97%
 * 
 */
public class Solution {
	public int numberOfBoomerangs(int[][] points) {
		if (points == null)
			return 0;
		int len = points.length;
		int res = 0;
		HashMap<Integer, Integer> dis = new HashMap<>();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (j != i) {
					int dis_temp = distance(points, i, j);
					dis.put(dis_temp, dis.getOrDefault(dis_temp, 0) + 1);
				}
			}
			for (int t : dis.values()) {
				if (t >= 2)
					res += (t - 1) * t;
			}
			dis.clear();
		}
		return res;
	}

	private int distance(int[][] points, int i, int j) {
		return (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
				+ (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
	}

	public static void main(String[] args) {
		int[][] test_in = { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
		Solution test = new Solution();
		System.out.println(test.numberOfBoomerangs(test_in));
	}

}
