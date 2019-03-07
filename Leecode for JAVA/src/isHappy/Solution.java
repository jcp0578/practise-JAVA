package isHappy;
/*
 * 快乐数
 * AC 3ms
 * 
 * 
 */
public class Solution {
    public boolean isHappy(int n) {
        int add_temp=n;
        for(;;)
        {	
            n=add_temp;
            add_temp=0;
		    while(n>0)
		    {
		    	add_temp+=(n%10)*(n%10);
		    	n/=10;
		    }
		    if(add_temp<10)
		    {
		    	if(add_temp==1||add_temp==7)
		    		return true;
		    	else
		    		return false;
		    }       	
        }

        
    }
}
