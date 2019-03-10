package clumsy;

import java.util.List;

public class Solution {
    public static int clumsy(int N) {
    	int out_t=0;
        if(N<=0)
        	return 0;
        else if(N==1)
        	return 1;
        else if(N==2)
        	return 2;
        else if(N==3)
        	return 6;
        else if(N==4)
        	return 7;
        else
        {
        	out_t=N*(N-1)/(N-2)+(N-3);
        }
        N-=4;
    	for(;N>0;N-=4)
    	{
            if(N<=0)
            	return out_t;
            else if(N==1)
            	out_t-=1;
            else if(N==2)
            	out_t-=2;
            else if(N==3)
            	out_t-=6;
            else
            {
            	int temp=N*(N-1)/(N-2)-(N-3);
            	out_t-=temp;
            }    		
    	}
    	return out_t;

    }
	public static void main(String[] args) {
		int num_in = 7;
		System.out.println(clumsy(num_in));

	}
}
