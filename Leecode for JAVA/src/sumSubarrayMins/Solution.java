package sumSubarrayMins;

/*
 * 子数组的最小值之和
 * 利用最小堆
 * 时间复杂度O(N^2logN) 
 * out time
 */
import java.util.PriorityQueue;

public class Solution {
    public int sumSubarrayMins(int[] A) {
        int sum=0;
        for(int i=0;i<A.length;i++)
        {
        	sum+=deal(A,i);
        	if(sum>=(1000000007))
        	{
        		sum%=(1000000007);
        	}
        }
        return sum;
    }
	private int deal(int[] a, int start) {
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		int sum=0;
		for(int i=start;i<a.length;i++)
		{
			queue.add(a[i]);
			sum+=queue.peek();
		}	
		return sum;
	}

	public static void main(String[] args) {
		int[] test_in= {85};
		Solution test=new Solution();
		System.out.println(test.sumSubarrayMins(test_in));
	}
}
