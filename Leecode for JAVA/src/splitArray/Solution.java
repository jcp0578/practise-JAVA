package splitArray;

/*
 * 分割数组的最大值
 * 二分搜索
 * AC
 * 2ms - 97.56%
 * 
 */
public class Solution {
	public int splitArray(int[] nums, int m) {
		if (nums == null)
			return 0;
		long sum=0;
		for(int t:nums)
		{
			sum+=t;
		}
		long left=sum/m;
		long right=sum;
		long mid;
		while(left<right)
		{
			mid=(left+right)>>1;
			if(this.judge(nums,m,mid))
			{
				right=mid;
			}
			else
			{
				left=mid+1;
			}
		}
		return (int)right;
	}

	private boolean judge(int[] nums, int m, long mid) {
		int sum=0;
		for(int t:nums)
		{
			if(t>mid)
				return false;
			if(sum+t>mid)
			{
				m--;
				sum=t;
			}
			else
			{
				sum+=t;
			}
		}
		return (m>0);
	}

	public static void main(String[] args) {
		int[] test_in = { 1,2147483647 };
		int test_m = 2;
		Solution test = new Solution();
		System.out.println(test.splitArray(test_in, test_m));
	}

}
