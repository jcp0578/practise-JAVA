package findKthLargest;
/*
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/submissions/
 * 
 * AC 3ms
 * 快速排序排一半
 */


public class Solution_2 {
	public static int findKthLargest(int[] nums, int k) {
		return findK(nums,0,nums.length-1,nums.length-k);

	}

	private static int findK(int[] nums, int start, int end, int k) {
		if(start==end)
			return nums[start];
		int i=start,j=end;
		int base=mid(nums[i],nums[j],nums[(i+j)/2]);
		while(i <=j)
		{
			while(nums[i]<base)
				i++;
			while(nums[j]>base)
				j--;
			if(i <=j)
			{
				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				i++;
				j--;
			}
		}
		if(k>= (i-start))
			return findK(nums,i,end,k-i+start);
		else
			return findK(nums,start,i-1,k);
	}

	private static int mid(int i, int j, int k) {
		if (i > j) {
			if (j > k)
				return j;
			else {
				return (i > k) ? k : i;
			}
		} else {
			if (i > k)
				return i;
			else {
				return (j > k) ? k : j;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums_in = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		System.out.println(findKthLargest(nums_in, k));
	}
}