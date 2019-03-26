package kthSmallestByMatrix;

import java.util.PriorityQueue;

/*
 * 有序矩阵中第K小的元素
 * 最大堆
 * AC but slow
 * 91ms - 14.36%
 * 
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len_y=matrix.length;
//        if(len_y==0)
//        	return -1;
        int len_x=matrix[0].length;
//        if(len_x==0)
//        	return -1;
    	PriorityQueue<Integer> max_heap=new PriorityQueue<>((a,b)->(b-a));
    	for(int i=0;i<len_y;i++)
    	{
    		if(max_heap.size()>=k && matrix[i][0]>max_heap.peek())
    		{
    			break;
    		}
    		for(int j=0;j<len_x;j++)
    		{
        		if(max_heap.size()>=k && matrix[i][j]>max_heap.peek())
        		{
        			break;
        		}
        		max_heap.offer(matrix[i][j]);
        		if(max_heap.size()>k)
        		{
        			max_heap.poll();
        		}
    		}
    	}
        return max_heap.peek();
    }
	public static void main(String[] args) {
		int[][] test_in = { {1,5,9},{10,11,13},{12,13,15} };
		int k=8;
		Solution test = new Solution();
		System.out.println(test.kthSmallest(test_in,k));
	}
}
