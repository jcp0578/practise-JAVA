package uniquePaths;

import java.math.BigInteger;

/*
 * https://leetcode-cn.com/problems/unique-paths/submissions/
 * 62. 不同路径
 * 1.该问题需考虑大数，但测试用例中并无
 * AC
 */
public class Solution {
    public static int uniquePaths(int m, int n) {
    	if(m<1||n<1)
    		return 0;
    	else if(m==1 || n==1)
    		return 1;
    	
    	BigInteger[] num_temp=new BigInteger[n];
        int i,j;
        for(i=0;i<n;i++)
        {
        	num_temp[i]=BigInteger.ONE;
        }
        for(i=1;i<m;i++)
        {
        	for(j=1;j<n;j++)
        	{
        		num_temp[j]=num_temp[j].add(num_temp[j-1]);
        	}
        }
        System.out.println(num_temp[n-1]);
        return num_temp[n-1].intValue();
    }
    
    /*
     * 
     	* 不考虑大数问题 
     * 
     */
    public int uniquePaths_2(int m, int n) {
    	if(m<1||n<1)
    		return 0;
    	else if(m==1 || n==1)
    		return 1;
    	
    	int[] num_temp=new int[n];
        int i,j;
        num_temp[0]=1;
        for(i=0;i<m;i++)
        {
        	for(j=1;j<n;j++)
        	{
        		num_temp[j]+=num_temp[j-1];
        	}
        }
        return num_temp[n-1];
    }
	public static void main(String[] args) {
		int num_in= 20,num_in2=20;
		System.out.println(uniquePaths(num_in,num_in2));
	}
}
