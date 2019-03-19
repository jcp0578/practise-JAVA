package canFinish;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 课程表
 * 构建邻接表后，DSP 遍历
 * 利用visited进行剪枝
 * AC 20ms-71.95%
 * 
 * @author JCP
 *
 */

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 1)
			return true;
		HashMap<Integer, ArrayList<Integer>> node_path = new HashMap<>();
		int len = prerequisites.length;
		if (len <= 1)
			return true;
		for (int i = 0; i < len; i++) {
			if (node_path.containsKey(prerequisites[i][0])) {
				ArrayList<Integer> add_temp = node_path.get(prerequisites[i][0]);
				add_temp.add(prerequisites[i][1]);
			} else {
				ArrayList<Integer> add_temp = new ArrayList<>();
				add_temp.add(prerequisites[i][1]);
				node_path.put(prerequisites[i][0], add_temp);
			}
		}
		int[] visiting = new int[numCourses];
		int[] visited = new int[numCourses];
		for(Integer node_temp:node_path.keySet())
		{
			if(visited[node_temp]==1)
				continue;
			visiting[node_temp] = 1;
			if(dsp(node_path, node_temp, visiting, visited)==false)
				return false;
			visiting[node_temp] = 0;
			visited[node_temp]=1;
		}
		return true;
	}

	private boolean dsp(HashMap<Integer, ArrayList<Integer>> node_path, int node, int[] visiting, int[] visited) {
		if (visited[node] == 1)// 已访问过，无问题
			return true;
		if (node_path.containsKey(node) == false) {
			visited[node] = 1;
			return true;
		}
		for (Integer temp_node : node_path.get(node)) {
			if (visited[node] == 1)// 已访问过，无问题
				return true;
			if (visiting[temp_node] == 1)
				return false;
			visiting[temp_node] = 1;
			if (dsp(node_path, temp_node, visiting, visited) == false)
				return false;
			visiting[temp_node] = 0;
		}
		visited[node] = 1;
		return true;
	}

	public static void main(String[] args) {
		int[][] num_in = { {2, 0 }, { 3, 1 },{3,2},{1,3} };
		int num = 4;
		Solution test = new Solution();
		System.out.println(test.canFinish(num, num_in));

	}

}
