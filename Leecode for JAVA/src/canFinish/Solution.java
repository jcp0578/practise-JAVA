package canFinish;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 课程表 
 * 构建邻接表后，DSP 遍历 利用visit_flag进行判断与剪枝
 * AC 11ms-88.51%
 * 
 * @author JCP
 *
 */

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 1)
			return true;
		ArrayList<Integer>[] node_path = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			node_path[i] = new ArrayList<>();

		int len = prerequisites.length;
		if (len <= 1)
			return true;
		for (int i = 0; i < len; i++)
			node_path[prerequisites[i][0]].add(prerequisites[i][1]);

		int[] visit_flag = new int[numCourses];
		//@1 正在访问  @-1无问题
		
		for (int i = 0; i < numCourses; i++) {
			if (dsp(node_path, i,visit_flag) == false)
				return false;
		}
		return true;
	}

	private boolean dsp(ArrayList<Integer>[] node_path, int node, int[] visit_flag) {
		if (visit_flag[node] == -1)// 已访问过，无问题
			return true;
		if (visit_flag[node] == 1)  //重复访问
			return false;
		visit_flag[node]=1;
		for (Integer temp_node : node_path[node]) {
			if (dsp(node_path, temp_node, visit_flag) == false)
				return false;
		}
		visit_flag[node]=-1;
		return true;
	}

	public static void main(String[] args) {
		int[][] num_in = { { 2, 0 }, { 3, 1 }, { 3, 2 }, { 1, 3 } };
		int num = 4;
		Solution test = new Solution();
		System.out.println(test.canFinish(num, num_in));

	}

}
