package findOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 课程表 2
 * 构建邻接表后，DSP 遍历 利用visit_flag进行判断与剪枝,将结果保存于stack中
 * AC 14ms-84.77%
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
			node_path[prerequisites[i][1]].add(prerequisites[i][0]);

		int[] visit_flag = new int[numCourses];
		//@1 正在访问  @-1无问题
		Stack<Integer> out_stack=new Stack<>();
		
		for (int i = 0; i < numCourses; i++) {
			if (dsp(node_path, i,visit_flag,out_stack) == false)
				return new int[0];
		}
		int[] out=new int[numCourses];
		for(int i=0;i<numCourses;i++)
			out[i]=out_stack.pop();
		return out;
	}

	private boolean dsp(ArrayList<Integer>[] node_path, int node, int[] visit_flag, Stack<Integer> out_stack) {
		if (visit_flag[node] == -1)// 已访问过，无问题
			return true;
		if (visit_flag[node] == 1)  //重复访问
			return false;
		visit_flag[node]=1;
		for (Integer temp_node : node_path[node]) {
			if (dsp(node_path, temp_node, visit_flag,out_stack) == false)
				return false;
		}
		visit_flag[node]=-1;
		out_stack.push(node);
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

