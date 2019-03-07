package spiralOrder;
/**
 * AC but not good
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> out_t=new ArrayList<Integer>();
    	int m,n;
    	n=matrix.length;
    	if(n==0)
    		return out_t;
    	m=matrix[0].length;
    	if(m==0)
    		return out_t;
    	
    	int i=0,j=0;
    	int k=0;
    	int out_flag=0;
    	while(k<((Math.min(m, n)+1)/2))
    	{
	    	if(out_flag!=0)
	    	{
	    		break;
	    	}
	    	for(i=k,j=k;j<m-k;j++)
	    	{
	    		out_t.add(matrix[i][j]);
	    		out_flag=1;
	    	}
	    	if(out_flag!=1)
	    	{
	    		break;
	    	}
	    	for(i=i+1,j=j-1;i<n-k;i++)
	    	{
	    		out_t.add(matrix[i][j]);
	    		out_flag=2;
	    	}
	    	if(out_flag!=2)
	    	{
	    		break;
	    	}
	    	for(j=j-1,i=i-1;j>(k-1);j--)
	    	{
	    		out_t.add(matrix[i][j]);
	    		out_flag=3;
	    	}
	    	if(out_flag!=3)
	    	{
	    		break;
	    	}
	    	for(i=i-1,j=j+1;i>(k);i--)
	    	{
	    		out_t.add(matrix[i][j]);
	    		out_flag=0;
	    	}
	    	k++;
    	}
		return out_t;
    	
    }
    
	public static void main(String[] args) {
		int[][] nums_in= {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
		System.out.println(spiralOrder(nums_in));
		int[][] nums_in2= {{1},{4},{7},{10},{13}};
		System.out.println(spiralOrder(nums_in2));
	}
}
