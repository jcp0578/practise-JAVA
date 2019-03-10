package largestSumAfterKNegations;

import java.util.Arrays;

public class Solution {
	
    public static int largestSumAfterKNegations(int[] A, int K) {
        int len=A.length;
        if(len<=0)
        	return 0;
        int sum=0;
        int[] count_t=new int[201];
        Arrays.fill(count_t,0);
        int neg_num=0;
        for(int num:A)
        {
        	if(num<0)
        	{
        		neg_num++;
        	}
        	count_t[num+100]++;
        	sum+=num;
        }
        int i=0,j=0;
        for(;i<len;)
        {
        	if(count_t[j]!=0)
        	{
        		A[i]=j-100;
        		count_t[j]--;
        		i++;
        	}
        	else
        	{
        		j++;
        	}
        }
        for(int l=0;l<K && l<neg_num;l++)
        {
        	A[l]=-A[l];
        	sum+=2*A[l];
        }
    	if(K<=neg_num)
    	{
    		return sum;
    	}
    	else
    	{
    		K=K-neg_num;
    		if((K&1)==1)
    		{
    			if(neg_num>0)
    				return sum-2*Math.min(A[neg_num], A[neg_num-1]);
    			else
    				return sum-2*A[neg_num];
    		}
    		else
    		{
    			return sum;
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] nums_in= {5,6,9,-3,3};
		int k=2;
		System.out.println(largestSumAfterKNegations(nums_in,k));
	}

}
