package merge;

import java.util.Arrays;

/*
 * 合并两个有序数组
 * 
 * AC  5 ms
 */
public class Solution {
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	
        int i=m-1;
        int j=n-1;
//        if(nums1.length < (m+n))//error
//        	return ;
        int k;
        for(k=m+n-1;k>0 && i>=0 && j>=0;k--)
        {
            if(nums1[i] >= nums2[j])
            {
            	nums1[k]=nums1[i];
            	i--;
            }
            else
            {
            	nums1[k]=nums2[j];
            	j--;
            }
        }
        for(;j>=0;j--)
        {
        	nums1[k--]=nums2[j];
        }
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] nums1 = {10,20,30,0,0,0,0};
		int[] nums2 = {2,5,6,7};
		merge(nums1,3,nums2,4);
		System.out.println(Arrays.toString(nums1));

	}
}
