package canCompleteCircuit;


/*
 * 加油站
 * 
 * AC but too slow
 */
public class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	int len=gas.length;
        int[] rest=new int[len];
        int sum=0;
        for(int i=0;i<len;i++)
        {
        	rest[i]=gas[i]-cost[i];
        	sum+=rest[i];
        }
        if(sum<0)
	        return -1;
        int last_index=0;
        int last_gap=0;
        for(int i=0;i<len;i++)
        {
        	if(rest[i] >=0)
        	{
        		int rest_sum=0;
        		for(int j=0;j<len;j++)
        		{
        			rest_sum+=rest[(i+j)%len];
        			if(rest_sum <0)
        			{
        				last_index=(i+j)%len;
        				last_gap=-rest_sum;
        				break;
        			}	
        		}
        		if(rest_sum>=0)
        			return i;
        	}
        	else
        	{
//        		last_gap-=rest[i];
        		continue;
        	}
        }
        return -1;
        	
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] gas  = {2};
		int[] cost = {2};
		System.out.println(canCompleteCircuit(gas,cost));

	}

}
