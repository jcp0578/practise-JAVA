package isBipartite;

/*
 * titel:785. 判断二分图
 * url:https://leetcode-cn.com/problems/is-graph-bipartite/submissions/
 * time : 1 ms - 97.25% 
 * memory : 38.6 MB - 95.74%
 * 
 * DFS
 * 
 * AC
 * 
 */
public class Solution {

	public boolean isBipartite(int[][] graph) {
		if (graph == null)
			return true;
		int len = graph.length;
		int[] flag = new int[len];
		for (int i = 0; i < len; i++) {
			if (flag[i] == 0) {
				flag[i] = 1;
				if (DFS(graph, flag, i) == false)
					return false;
			}
		}

		return true;
	}

	private boolean DFS(int[][] graph, int[] flag, int curIndex) {
		int arrayLen = graph[curIndex].length;
		int shouldFlag = (flag[curIndex] == 1) ? 2 : 1;
		for (int i = 0; i < arrayLen; i++) {
			if (flag[graph[curIndex][i]] == 0) {
				flag[graph[curIndex][i]] = shouldFlag;
				if(DFS(graph, flag, graph[curIndex][i]) == false)
					return false;
			} else if (flag[graph[curIndex][i]] == shouldFlag) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] test_in = 
				{{2,3,5,6,7,8,9},{2,3,4,5,6,7,8,9},{0,1,3,4,5,6,7,8,9},{0,1,2,4,5,6,7,8,9},{1,2,3,6,9},{0,1,2,3,7,8,9},{0,1,2,3,4,7,8,9},{0,1,2,3,5,6,8,9},{0,1,2,3,5,6,7},{0,1,2,3,4,5,6,7}};

		Solution test = new Solution();
		System.out.println(test.isBipartite(test_in));

	}

}
