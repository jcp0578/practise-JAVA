package findOrder;

import java.util.ArrayList;

/**
 * 课程表 2
 * 构建邻接表后，DSP 遍历 利用visit_flag进行判断与剪枝,将结果保存于ArrayList中(效率好于Stack)
 * AC 11ms-90.95%
 * 
 * @author JCP
 *
 */

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
    	ArrayList<Integer>[] node_path = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			node_path[i] = new ArrayList<>();

		int len = prerequisites.length;
		for (int i = 0; i < len; i++)
			node_path[prerequisites[i][0]].add(prerequisites[i][1]);

		int[] visit_flag = new int[numCourses];
		//@1 正在访问  @-1无问题
		ArrayList<Integer> out_t = new ArrayList<>();
		
		for (int i = 0; i < numCourses; i++) {
			if (dsp(node_path, i,visit_flag,out_t) == false)
				return new int[0];
		}
		int[] out=new int[numCourses];
		for(int i=0;i<numCourses;i++)
			out[i]=out_t.get(i);
		return out;
	}

	private boolean dsp(ArrayList<Integer>[] node_path, int node, int[] visit_flag, ArrayList<Integer> out_t) {
		if (visit_flag[node] == -1)// 已访问过，无问题
			return true;
		if (visit_flag[node] == 1)  //重复访问
			return false;
		visit_flag[node]=1;
		for (Integer temp_node : node_path[node]) {
			if (dsp(node_path, temp_node, visit_flag,out_t) == false)
				return false;
		}
		visit_flag[node]=-1;
		out_t.add(node);
		return true;
	}

	public static void main(String[] args) {
		int[][] num_in = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int num = 4;
		Solution test = new Solution();
		int[] out=test.findOrder(num, num_in);
		if(out!=null)
		{
			System.out.print("[");
			for(int temp:out)
			{
				
				System.out.print(temp);
				System.out.print(',');
			}
			System.out.print("]");
		}
		else
		{
			System.out.println("[]");
		}

		

	}

}

