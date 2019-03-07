package spiralOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution_fast {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> list=new ArrayList<Integer>();
	        if(matrix.length==0)
	            return list;
	        for(int i=0;list.size()<matrix.length*matrix[0].length;i++)
	        {
	            for(int j=i;j<matrix[0].length-i;j++)
	                list.add(matrix[i][j]);
	            for(int k=i+1;k<matrix.length-i-1;k++)
	                list.add(matrix[k][matrix[0].length-1-i]);
	            if(matrix.length-1-i>i)
	            {
	                for(int m=matrix[0].length-i-1;m>=i;m--)
	                list.add(matrix[matrix.length-1-i][m]);
	            }
	            if(matrix[0].length-1-i>i)
	            {
	                for(int n=matrix.length-i-2;n>i;n--)
	                list.add(matrix[n][i]);
	            }
	           
	        }
	        return list;
	    }
}
