package getSkyline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 天际线问题
 * https://leetcode-cn.com/problems/the-skyline-problem/
 * 参考：https://segmentfault.com/a/1190000003786782
 * 
 * AC but too slow
 */
public class Solution {
	public List<int[]> getSkyline(int[][] buildings) {
		int len = buildings.length;
		ArrayList<int[]> out_t = new ArrayList<>();
		ArrayList<int[]> height = new ArrayList<>();
		if (len == 0)
			return out_t;
		
        for(int[] b:buildings) {
            // 左顶点存为负数
            height.add(new int[]{b[0], -b[2]});
            // 右顶点存为正数
            height.add(new int[]{b[1], b[2]});
        }
        
        // 根据横坐标对列表排序，相同横坐标的点纵坐标小的排在前面
        Collections.sort(height, new Comparator<int[]>() {
			public int compare(int[] t1, int[] t2) {
				if (t1[0] != t2[0])
					return t1[0] -t2[0];
				else
					return t1[1] -t2[1];
			}
		});
        
        // 构建堆，按照纵坐标来判断大小
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        // 将地平线值先加入堆中
        pq.offer(0);
        // prev用于记录上次keypoint的高度
        int prev = 0;
        for(int[] h:height) {
            // 将左顶点加入堆中
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
            // 将右顶点对应的左顶点移去
                pq.remove(h[1]);
            }
            int now = pq.peek();
            // 如果堆的新顶部和上个keypoint高度不一样，则加入一个新的keypoint
            if(prev != now) {
            	out_t.add(new int[]{h[0], now});
                prev = now;
            }
        } 
		return out_t;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[][] num_in = { { 15, 20, 10 }, { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 19, 24, 8 } };
		Solution test = new Solution();
		List<int[]> out = test.getSkyline(num_in);
		for(int[] t:out)
		{
			System.out.print("[ ");
			for(int tt:t)
			{
				System.out.print(tt);
				System.out.print(", ");
			}
			System.out.print("], ");
		}
		
	}

}
