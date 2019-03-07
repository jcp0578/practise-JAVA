package numSquares;


/*
 * 四平方定理
 * 
 */
public class Solution_fast {
	// 贪心算法不适用
	// e.g. 12 = 9+1+1+1 输出的是4 错误答案
	// “最小” -> 想到最短路径 -> bfs算法 但这不是最优！
	// public int numSquares(int n) {
	// Queue<Integer[]> queue = new LinkedList<>();
	// queue.offer(new Integer[] { 0, 0 });// 保存当前元素和已经用了的步数
	// boolean[] visited = new boolean[n + 1];
	// visited[0] = true;
	// //bfs
	// while (!queue.isEmpty()) {
	// Integer[] cur = queue.poll();
	// int num = cur[0];
	// int step = cur[1];
	// int i = 1;
	// int tNum = num + i * i;
	// while (tNum <= n) {//从 0->n 搜索不重复的和，一旦重复说明出现过，例如1+9=9+1=10，就不再添加
	// if (tNum == n)
	// return step + 1;
	// if (!visited[tNum]) {
	// queue.offer(new Integer[] { tNum, step + 1 });
	// visited[tNum] = true;
	// }
	// i += 1;
	// tNum = num + i * i;
	// }
	// }
	// return 0;
	// }

	// Lagrange 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
	// 结果只有1,2,3,4，四种可能。
	// 推论：满足四数平方和定理的数n（必须满足由四个数构成），必定满足 n=4^a*(8^b+7)
	public int numSquares(int n) {
		while (n % 4 == 0) {
			n /= 4;
		}
		if (n % 8 == 7) // 满足推论 说明由4个完全平方数构成
			return 4;
		int a = 0;
		while (a * a <= n) {
			// 判断这个缩小后的数是否可以通过两个平方数的和或一个平方数组成
			int b = (int) (Math.sqrt((n - a * a)));// 如果n=a^2 那么b=0
			// if (a * a == n)
			// return 1;
			if (a * a + b * b == n)
				// 返回 a、b中非0的个数和
				return (a != 0 ? 1 : 0) + (b != 0 ? 1 : 0);
			a += 1;
		}
		return 3;
	}
}
